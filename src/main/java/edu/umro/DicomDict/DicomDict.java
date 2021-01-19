package edu.umro.DicomDict;

import com.pixelmed.dicom.DicomDictionary;

import java.io.InputStream;
import java.util.Properties;

/**
 * Instantiate DICOM tags that are used in UMRO applications.  When the Pixelmed library
 * changed to a subset of tags defined by <code>TagFromName</code>, several tags were
 * suddenly gone.  While they can be looked up at run time, this loses the safety of having
 * the names checked at compile time.  This utility fixes that.
 */
public class DicomDict {

    public static DicomDictionary dict = TagByName.dict;

    private static final String manifestPropertiesName = "/manifest.properties";
    private static final Class classy = (new DicomDict()).getClass();

    private static Properties readManifest() {
        Properties p = new Properties();
        try {
            InputStream i = classy.getResourceAsStream(manifestPropertiesName);
            p.load(i);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("badness");
        }
        return p;
    }

    /**
     * Print the name of this class and the properties from the manifest.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(classy.getName());

        Properties p = readManifest();
        p.list(System.out);
    }
}
