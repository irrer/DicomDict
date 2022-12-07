/*
 * Copyright 2021 Regents of the University of Michigan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
     *
     * @param args
     */
    public static void main(String[] args) {
        Properties p = readManifest();
        p.list(System.out);
    }
}
