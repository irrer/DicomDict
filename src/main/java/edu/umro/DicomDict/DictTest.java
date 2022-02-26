package edu.umro.DicomDict;

import com.pixelmed.dicom.*;

/**
 * Generate the TagByName file from the TagByName.txt file.
 * <p>
 * Also look through the src/main/resources/dicom directory, and for
 * each DICOM file in it, add their tags.  This provides an easy way
 * to add tags from other sources.
 */
public class DictTest {

    private static final DicomDictionary dict = TagByName.dict;

    public static void main(String[] args) {

        try {
            System.out.println("Hey");

            AttributeTag PatientID = dict.getTagFromName("PatientID");
            System.out.println("PatientID: " + PatientID);

            AttributeTag SPSCode = dict.getTagFromName("SPSCode");
            System.out.println("SPSCode: " + SPSCode);

            System.out.println("dict: " + dict);

            System.out.println("Done");
        } catch (Exception ex) {
            System.err.println("Unexpected exception: " + ex);
            ex.printStackTrace();
        }

    }
}
