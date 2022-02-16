package edu.umro.DicomDict;

import com.pixelmed.dicom.DicomDictionary;
import edu.umro.util.UMROException;
import edu.umro.util.Utility;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Generate the TagByName file from the TagByName.txt file.
 */
public class MakeTagByName {

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
        String prefix = sections[0].replaceAll("TagByNameTemplate", "TagByName");
        String suffix = sections[sections.length - 1];

        return new String[]{prefix, suffix};
    }

    /**
     * Read the list of tags to be put in TagByName and return the sorted list.
     *
     * @return Sorted list of tags from the standard dictionary.
     * @throws UMROException On reading file.
     */
    private static SortedSet<String> getList() throws UMROException {
        String fileName = "src\\main\\resources\\TagByName.txt";

        String text = Utility.readFile(new File(fileName));
        String[] fullList = text.split("[ \r\n][ \r\n]*");

        SortedSet<String> set = new TreeSet<>();

        int i;
        for (i = 0; i < fullList.length; i++) {
            set.add(fullList[i]);
        }

        return set;
    }

    public static void main(String[] args) {

        try {
            DicomDictionary verifyDict = new DicomDictionary();

            String[] pair = extractTemplate();
            String prefix = pair[0];
            String suffix = pair[1];

            StringBuilder output = new StringBuilder();
            output.append(prefix);
            output.append("\n");

            SortedSet<String> list = getList();

            Iterator<String> itr = list.iterator();

            //noinspection WhileLoopReplaceableByForEach
            while (itr.hasNext()) {
                String value = itr.next();

                // test that this DICOM tag is in the standard dictionary.  (The dictionary changes occasionally.)
                if (verifyDict.getTagFromName(value) == null) {
                    throw new RuntimeException("DICOM tag not in the standard dictionary. " + " : >>" + value + "<<");
                }

                String line = "    public static final AttributeTag " + value + " = dict.getTagFromName(\"" + value + "\");\n";
                output.append(line);
            }

            output.append(suffix);

            File outputFile = new File("src\\main\\java\\edu\\umro\\DicomDict\\TagByName.java");
            byte[] outputText = output.toString().getBytes(StandardCharsets.UTF_8);
            Utility.writeFile(outputFile, outputText);
            System.out.println("Done.  Output file: " + outputFile.getAbsolutePath() + "    File size: " + outputText.length + "    Number of attributes: " + list.size());

        } catch (Exception ex) {
            System.err.println("Unexpected exception: " + ex);
            ex.printStackTrace();
        }

    }
}
