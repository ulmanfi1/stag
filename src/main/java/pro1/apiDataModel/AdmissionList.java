package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AdmissionList {
    @SerializedName("prijimaciObor")
    public List<Admission> prijimaciObor;
}
