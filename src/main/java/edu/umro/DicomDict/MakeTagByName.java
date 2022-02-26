package edu.umro.DicomDict;

import com.pixelmed.dicom.*;
import edu.umro.util.UMROException;
import edu.umro.util.Utility;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Generate the TagByName file from the TagByName.txt file.
 * <p>
 * Also look through the src/main/resources/dicom directory, and for
 * each DICOM file in it, add their tags.  This provides an easy way
 * to add tags from other sources.
 */
public class MakeTagByName {

    private static final DicomDictionary dict = new DicomDictionary();

    /**
     * Get the template for creating the TagByName file.
     *
     * @return Prefix and suffix.
     * @throws UMROException Reading files.
     */
    private static String[] extractTemplate() throws UMROException {
        String separator = "////////*";
        File TagByNameTemplate = new File("src\\main\\java\\edu\\umro\\DicomDict\\TagByNameTemplate.java");
        String text = Utility.readFile(TagByNameTemplate);
        String[] sections = text.split(separator);
        String prefix = sections[0].replaceAll("TagByNameTemplate", "TagByName"); // .replaceAll("ExtendedDictionaryTemplate", "ExtendedDictionary");
        String suffix = sections[sections.length - 1];

        return new String[]{prefix, suffix};
    }

    private static void addTagsFromAttributeList(AttributeList al, SortedSet<String> set) {

        Iterator<AttributeTag> itr = al.keySet().iterator();

        //noinspection WhileLoopReplaceableByForEach
        while (itr.hasNext()) {
            AttributeTag tag = itr.next();

            String name = dict.getNameFromTag(tag);
            if (name != null) {
                set.add(name);
                if (ValueRepresentation.isSequenceVR(dict.getValueRepresentationFromTag(tag))) {
                    SequenceAttribute seq = (SequenceAttribute) (al.get(tag));
                    int i;
                    for (i = 0; i < seq.getNumberOfItems(); i++) {
                        addTagsFromAttributeList(seq.getItem(i).getAttributeList(), set);
                    }
                }
            }
        }
    }

    private static AttributeList readDicomFile(File file) {
        try {
            AttributeList al = new AttributeList();
            al.read(file);
            return al;
        } catch (Exception ex) {
            System.out.println("Unable to process DICOM file " + file.getAbsolutePath() + ex);
            return null;
        }
    }

    private static void addTagsFromDicomFiles(SortedSet<String> set) {
        File dicomDir = new File("src\\main\\resources\\dicom");
        File[] dicomFileList = dicomDir.listFiles();
        int i;
        if (dicomFileList == null) {
            throw new RuntimeException("Could not find dir " + dicomDir.getAbsolutePath());
        }
        for (i = 0; i < dicomFileList.length; i++) {
            AttributeList al = readDicomFile(dicomFileList[i]);
            if (al != null) {
                addTagsFromAttributeList(al, set);
                System.out.println("Total tags: " + set.size() + " Added tags from DICOM file " + dicomFileList[i].getAbsolutePath());
            }
        }
    }

    /**
     * Read the list of tags to be put in TagByName and return the sorted list.
     *
     * @throws UMROException On reading file.
     */
    private static void addTagsFromTextFile(SortedSet<String> set) throws UMROException {
        String fileName = "src\\main\\resources\\TagByName.txt";

        File textFile = new File(fileName);

        String text = Utility.readFile(textFile);
        String[] fullList = text.split("[ \r\n][ \r\n]*");


        int i;
        for (i = 0; i < fullList.length; i++) {
            set.add(fullList[i]);
        }
        System.out.println("Total tags: " + set.size() + " Added tags from text file " + textFile);
    }

    private static void verifyTagMembershipInStandardDictionary(SortedSet<String> set) {
        Iterator<String> itr = set.iterator();

        //noinspection WhileLoopReplaceableByForEach
        while (itr.hasNext()) {
            String value = itr.next();

            // test that this DICOM tag is in the standard dictionary.  (The dictionary changes occasionally.)
            if (dict.getTagFromName(value) == null) {
                throw new RuntimeException("DICOM tag not in the standard dictionary. " + " : >>" + value + "<<");
            }
        }
    }

    private static String readPrivateTags() throws UMROException {
        String fileName = "src\\main\\resources\\PrivateTags.java";
        File textFile = new File(fileName);
        String text = Utility.readFile(textFile);
        return text;
    }

    public static void main(String[] args) {

        try {
            String[] pair = extractTemplate();
            String prefix = pair[0];
            String suffix = pair[1];

            SortedSet<String> set = new TreeSet<>();

            addTagsFromTextFile(set);
            addTagsFromDicomFiles(set);

            verifyTagMembershipInStandardDictionary(set);

            Iterator<String> itr = set.iterator();

            StringBuilder output = new StringBuilder();
            output.append(prefix);
            output.append("\n");
            while (itr.hasNext()) {
                String value = itr.next();
                String line = "    public static final AttributeTag " + value + " = dict.getTagFromName(\"" + value + "\");\n";
                output.append(line);
            }

            output.append(readPrivateTags());

            output.append("\n\n// Private tags below.\n");

            output.append(suffix);

            File outputFile = new File("src\\main\\java\\edu\\umro\\DicomDict\\TagByName.java");
            byte[] outputText = output.toString().getBytes(StandardCharsets.UTF_8);
            Utility.writeFile(outputFile, outputText);
            System.out.println("Done.  Output file: " + outputFile.getAbsolutePath() + "    File size: " + outputText.length + "    Number of attributes: " + set.size());

        } catch (Exception ex) {
            System.err.println("Unexpected exception: " + ex);
            ex.printStackTrace();
        }

    }
}
