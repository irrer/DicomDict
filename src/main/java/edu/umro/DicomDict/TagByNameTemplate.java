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

import com.pixelmed.dicom.AttributeTag;
import com.pixelmed.dicom.DicomDictionary;

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
    public static final DicomDictionary dict = DicomDictionary.StandardDictionary;
    /////////////////////////////
    public final AttributeTag tag = null; // force the import of AttributeTag
    /////////////////////////////
}
