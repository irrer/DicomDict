package edu.umro.DicomDict;

import com.pixelmed.dicom.AttributeTag;
import com.pixelmed.dicom.DicomDictionary;

/**
 * Define a <code>AttributeTag</code> list that includes standard tags that are not included
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
 *
 * When the Pixelmed library
 * changed to a subset of tags defined by <code>TagFromName</code>, several tags were
 * suddenly gone.  While they can be looked up at run time, this loses the safety of having
 * the names checked at compile time.  This utility fixes that.
 * </p>
 *
 */
public class TagByName {

    public static final DicomDictionary dict = DicomDictionary.StandardDictionary;

    public static final AttributeTag AbortFlag = dict.getTagFromName("AbortFlag");
    public static final AttributeTag ApprovalStatus = dict.getTagFromName("ApprovalStatus");
    public static final AttributeTag AxisLabels = dict.getTagFromName("AxisLabels");
    public static final AttributeTag AxisUnits = dict.getTagFromName("AxisUnits");
    public static final AttributeTag BeamLimitingDeviceAngle = dict.getTagFromName("BeamLimitingDeviceAngle");
    public static final AttributeTag BeamLimitingDeviceAngleTolerance = dict.getTagFromName("BeamLimitingDeviceAngleTolerance");
    public static final AttributeTag BeamLimitingDevicePositionSequence = dict.getTagFromName("BeamLimitingDevicePositionSequence");
    public static final AttributeTag BeamLimitingDevicePositionTolerance = dict.getTagFromName("BeamLimitingDevicePositionTolerance");
    public static final AttributeTag BeamLimitingDeviceSequence = dict.getTagFromName("BeamLimitingDeviceSequence");
    public static final AttributeTag BeamLimitingDeviceToleranceSequence = dict.getTagFromName("BeamLimitingDeviceToleranceSequence");
    public static final AttributeTag BeamName = dict.getTagFromName("BeamName");
    public static final AttributeTag BeamNumber = dict.getTagFromName("BeamNumber");
    public static final AttributeTag BeamSequence = dict.getTagFromName("BeamSequence");
    public static final AttributeTag BrachyTreatmentType = dict.getTagFromName("BrachyTreatmentType");
    public static final AttributeTag CineRate = dict.getTagFromName("CineRate");
    public static final AttributeTag ContourGeometricType = dict.getTagFromName("ContourGeometricType");
    public static final AttributeTag ContourImageSequence = dict.getTagFromName("ContourImageSequence");
    public static final AttributeTag ContourSequence = dict.getTagFromName("ContourSequence");
    public static final AttributeTag ControlPointSequence = dict.getTagFromName("ControlPointSequence");
    public static final AttributeTag CreationDate = dict.getTagFromName("CreationDate");
    public static final AttributeTag CreationTime = dict.getTagFromName("CreationTime");
    public static final AttributeTag CumulativeDoseReferenceCoefficient = dict.getTagFromName("CumulativeDoseReferenceCoefficient");
    public static final AttributeTag CumulativeMetersetWeight = dict.getTagFromName("CumulativeMetersetWeight");
    public static final AttributeTag CurveData = dict.getTagFromName("CurveData");
    public static final AttributeTag CurveDescription = dict.getTagFromName("CurveDescription");
    public static final AttributeTag CurveDimensions = dict.getTagFromName("CurveDimensions");
    public static final AttributeTag CurveLabel = dict.getTagFromName("CurveLabel");
    public static final AttributeTag DataValueRepresentation = dict.getTagFromName("DataValueRepresentation");
    public static final AttributeTag DoseGridScaling = dict.getTagFromName("DoseGridScaling");
    public static final AttributeTag DoseRateSet = dict.getTagFromName("DoseRateSet");
    public static final AttributeTag DoseReferenceUID = dict.getTagFromName("DoseReferenceUID");
    public static final AttributeTag DoseUnits = dict.getTagFromName("DoseUnits");
    public static final AttributeTag ExposureSequence = dict.getTagFromName("ExposureSequence");
    public static final AttributeTag ExposureTime = dict.getTagFromName("ExposureTime");
    public static final AttributeTag FluenceMode = dict.getTagFromName("FluenceMode");
    public static final AttributeTag FluenceModeID = dict.getTagFromName("FluenceModeID");
    public static final AttributeTag FractionGroupSequence = dict.getTagFromName("FractionGroupSequence");
    public static final AttributeTag FrameOfReferenceTransformationMatrix = dict.getTagFromName("FrameOfReferenceTransformationMatrix");
    public static final AttributeTag GantryAngle = dict.getTagFromName("GantryAngle");
    public static final AttributeTag GantryAngleTolerance = dict.getTagFromName("GantryAngleTolerance");
    public static final AttributeTag ImagePlanePixelSpacing = dict.getTagFromName("ImagePlanePixelSpacing");
    public static final AttributeTag IsocenterPosition = dict.getTagFromName("IsocenterPosition");
    public static final AttributeTag KVP = dict.getTagFromName("KVP");
    public static final AttributeTag LeafJawPositions = dict.getTagFromName("LeafJawPositions");
    public static final AttributeTag LeafPositionBoundaries = dict.getTagFromName("LeafPositionBoundaries");
    public static final AttributeTag MatrixRegistrationSequence = dict.getTagFromName("MatrixRegistrationSequence");
    public static final AttributeTag MatrixSequence = dict.getTagFromName("MatrixSequence");
    public static final AttributeTag NominalBeamEnergy = dict.getTagFromName("NominalBeamEnergy");
    public static final AttributeTag NumberOfBeams = dict.getTagFromName("NumberOfBeams");
    public static final AttributeTag NumberOfContourPoints = dict.getTagFromName("NumberOfContourPoints");
    public static final AttributeTag NumberOfPoints = dict.getTagFromName("NumberOfPoints");
    public static final AttributeTag NumberOfWedges = dict.getTagFromName("NumberOfWedges");
    public static final AttributeTag ObservationNumber = dict.getTagFromName("ObservationNumber");
    public static final AttributeTag PatientSetupNumber = dict.getTagFromName("PatientSetupNumber");
    public static final AttributeTag PatientSetupSequence = dict.getTagFromName("PatientSetupSequence");
    public static final AttributeTag PatientSupportAngle = dict.getTagFromName("PatientSupportAngle");
    public static final AttributeTag PositionerMotion = dict.getTagFromName("PositionerMotion");
    public static final AttributeTag PrimaryDosimeterUnit = dict.getTagFromName("PrimaryDosimeterUnit");
    public static final AttributeTag PrimaryFluenceModeSequence = dict.getTagFromName("PrimaryFluenceModeSequence");
    public static final AttributeTag RadiationMachineName = dict.getTagFromName("RadiationMachineName");
    public static final AttributeTag RadiationMachineSAD = dict.getTagFromName("RadiationMachineSAD");
    public static final AttributeTag RadiationType = dict.getTagFromName("RadiationType");
    public static final AttributeTag RecommendedDisplayFrameRate = dict.getTagFromName("RecommendedDisplayFrameRate");
    public static final AttributeTag ReferencedBeamNumber = dict.getTagFromName("ReferencedBeamNumber");
    public static final AttributeTag ReferencedBeamSequence = dict.getTagFromName("ReferencedBeamSequence");
    public static final AttributeTag ReferencedBolusSequence = dict.getTagFromName("ReferencedBolusSequence");
    public static final AttributeTag ReferencedFractionGroupSequence = dict.getTagFromName("ReferencedFractionGroupSequence");
    public static final AttributeTag ReferencedFrameOfReferenceSequence = dict.getTagFromName("ReferencedFrameOfReferenceSequence");
    public static final AttributeTag ReferencedPatientSetupNumber = dict.getTagFromName("ReferencedPatientSetupNumber");
    public static final AttributeTag ReferencedROINumber = dict.getTagFromName("ReferencedROINumber");
    public static final AttributeTag ReferencedRTPlanSequence = dict.getTagFromName("ReferencedRTPlanSequence");
    public static final AttributeTag ReferencedStructureSetSequence = dict.getTagFromName("ReferencedStructureSetSequence");
    public static final AttributeTag RegistrationSequence = dict.getTagFromName("RegistrationSequence");
    public static final AttributeTag ROIContourSequence = dict.getTagFromName("ROIContourSequence");
    public static final AttributeTag ROIDisplayColor = dict.getTagFromName("ROIDisplayColor");
    public static final AttributeTag ROIGenerationAlgorithm = dict.getTagFromName("ROIGenerationAlgorithm");
    public static final AttributeTag ROIInterpreter = dict.getTagFromName("ROIInterpreter");
    public static final AttributeTag ROIName = dict.getTagFromName("ROIName");
    public static final AttributeTag ROINumber = dict.getTagFromName("ROINumber");
    public static final AttributeTag RTBeamLimitingDeviceType = dict.getTagFromName("RTBeamLimitingDeviceType");
    public static final AttributeTag RTImageDescription = dict.getTagFromName("RTImageDescription");
    public static final AttributeTag RTImageLabel = dict.getTagFromName("RTImageLabel");
    public static final AttributeTag RTImagePlane = dict.getTagFromName("RTImagePlane");
    public static final AttributeTag RTImagePosition = dict.getTagFromName("RTImagePosition");
    public static final AttributeTag RTImageSID = dict.getTagFromName("RTImageSID");
    public static final AttributeTag RTPlanLabel = dict.getTagFromName("RTPlanLabel");
    public static final AttributeTag RTPlanName = dict.getTagFromName("RTPlanName");
    public static final AttributeTag RTPlanDate = dict.getTagFromName("RTPlanDate");
    public static final AttributeTag RTPlanTime = dict.getTagFromName("RTPlanTime");
    public static final AttributeTag RTPlanDescription = dict.getTagFromName("RTPlanDescription");
    public static final AttributeTag RTReferencedSeriesSequence = dict.getTagFromName("RTReferencedSeriesSequence");
    public static final AttributeTag RTReferencedStudySequence = dict.getTagFromName("RTReferencedStudySequence");
    public static final AttributeTag RTROIInterpretedType = dict.getTagFromName("RTROIInterpretedType");
    public static final AttributeTag RTROIObservationsSequence = dict.getTagFromName("RTROIObservationsSequence");
    public static final AttributeTag StartTrim = dict.getTagFromName("StartTrim");
    public static final AttributeTag StopTrim = dict.getTagFromName("StopTrim");
    public static final AttributeTag StructureSetDescription = dict.getTagFromName("StructureSetDescription");
    public static final AttributeTag StructureSetName = dict.getTagFromName("StructureSetName");
    public static final AttributeTag StructureSetROISequence = dict.getTagFromName("StructureSetROISequence");
    public static final AttributeTag TableTopEccentricAngle = dict.getTagFromName("TableTopEccentricAngle");
    public static final AttributeTag TableTopLateralPosition = dict.getTagFromName("TableTopLateralPosition");
    public static final AttributeTag TableTopLongitudinalPosition = dict.getTagFromName("TableTopLongitudinalPosition");
    public static final AttributeTag TableTopPitchAngle = dict.getTagFromName("TableTopPitchAngle");
    public static final AttributeTag TableTopRollAngle = dict.getTagFromName("TableTopRollAngle");
    public static final AttributeTag TableTopVerticalPosition = dict.getTagFromName("TableTopVerticalPosition");
    public static final AttributeTag TemporalPositionIdentifier = dict.getTagFromName("TemporalPositionIdentifier");
    public static final AttributeTag ToleranceTableLabel = dict.getTagFromName("ToleranceTableLabel");
    public static final AttributeTag ToleranceTableSequence = dict.getTagFromName("ToleranceTableSequence");
    public static final AttributeTag TreatmentMachineName = dict.getTagFromName("TreatmentMachineName");
    public static final AttributeTag TypeOfData = dict.getTagFromName("TypeOfData");
    public static final AttributeTag WedgeOrientation = dict.getTagFromName("WedgeOrientation");
    public static final AttributeTag WedgeSequence = dict.getTagFromName("WedgeSequence");
    public static final AttributeTag XRayImageReceptorAngle = dict.getTagFromName("XRayImageReceptorAngle");
    public static final AttributeTag XRayImageReceptorTranslation = dict.getTagFromName("XRayImageReceptorTranslation");
    public static final AttributeTag XRayTubeCurrent = dict.getTagFromName("XRayTubeCurrent");

}
