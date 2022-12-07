/*
 * Copyright 2022 Regents of the University of Michigan
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

import com.pixelmed.dicom.AttributeTag;
import com.pixelmed.dicom.InformationEntity;


/**
 * Define an <code>AttributeTag</code> list that includes standard tags that are not included
 * by the new Pixelmed DICOM dictionary, but are used by UMRO programs.
 * <p>
 * The name <code>TagFromName</code> allows simple migration by changing import statements as follows:
 * </p>
 * <p>
 * import com.pixelmed.dicom.TagFromName;  // change from this old way
 * import edu.umro.TagFromName;            // to this new way
 *
 * </p>
 * <p>
 * <p>
 * When the Pixelmed library changed to a subset of tags defined by <code>TagFromName</code>, several tags were
 * suddenly gone.  While they can be looked up at run time, this loses the safety of having
 * the names checked at compile time.  This utility fixes that.
 * </p>
 */
@SuppressWarnings("unused")
public class TagByNameTemplate {

    public static ExtendedDictionary dict = new ExtendedDictionary();

    private static AttributeTag add(String name, int group, int element, byte[] vr, String fullName, InformationEntity informationEntity) {
        return dict.add(name, group, element, vr, fullName, informationEntity);
    }

    /**
     * Add multiple private attributes to the dictionary.
     *
     * @param name              Attribute name.
     * @param firstGroup        First group.
     * @param lastGroup         Last group (inclusive).
     * @param groupIncrement    Group groupIncrement.
     * @param element           Element.
     * @param vr                Value representation.
     * @param fullName          Full name.
     * @param informationEntity Information Entity.
     * @return Attribute tag.
     */
    @SuppressWarnings("SameParameterValue")
    private static AttributeTag addMultiple(String name, int firstGroup, int lastGroup, int groupIncrement, int element, byte[] vr, String fullName, InformationEntity informationEntity) {
        for (int group = firstGroup; group <= lastGroup; group += groupIncrement) {
            String hex = String.format("0x%04X", group);
            dict.add(name + hex, group, element, vr, fullName + hex, informationEntity);
        }

        return new AttributeTag(firstGroup, element);
    }

    /////////////////////////////
    public final AttributeTag tag = null; // force the import of AttributeTag
    /////////////////////////////
}
