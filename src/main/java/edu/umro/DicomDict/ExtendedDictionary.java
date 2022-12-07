package edu.umro.DicomDict;


import com.pixelmed.dicom.AttributeTag;
import com.pixelmed.dicom.DicomDictionary;
import com.pixelmed.dicom.InformationEntity;

public class ExtendedDictionary extends DicomDictionary {

    @Override
    protected void createTagList() {
        super.createTagList();
    }

    @Override
    protected void createValueRepresentationsByTag() {
        super.createValueRepresentationsByTag();
    }

    @Override
    protected void createInformationEntityByTag() {
        super.createInformationEntityByTag();
    }

    @Override
    protected void createTagByName() {
        super.createTagByName();
    }

    @Override
    protected void createNameByTag() {
        super.createNameByTag();
    }

    @Override
    protected void createFullNameByTag() {
        super.createFullNameByTag();
    }

    @SuppressWarnings("unchecked")
    public AttributeTag add(String name, int group, int element, byte[] vr, String fullName, InformationEntity informationEntity) {
        AttributeTag tag = new AttributeTag(group, element);
        if (tagList.contains(tag)) {
            // System.out.println("tag: " + tag + "  name: " + name + "    previous name: " + nameByTag.get(tag));
        } else {
            // throw new RuntimeException("Tag already exists in dictionary: " + tag + " Name: " + name);
            tagList.add(tag);
            valueRepresentationsByTag.put(tag, vr);
            informationEntityByTag.put(tag, informationEntity);
            nameByTag.put(tag, name);
            tagByName.put(name, tag);
            fullNameByTag.put(tag, fullName);
        }
        return tag;
    }
}
