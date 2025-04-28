package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.AdmissionList;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Main7 {
    public static void main(String[] args) {
        System.out.println(specializationDeadlines(2025));
    }

    public static String specializationDeadlines(int year) {
        String json = Api.getSpecializations(year);
        AdmissionList admissionList = new Gson().fromJson(json, AdmissionList.class);

        Comparator<String> dateComparator = Comparator.comparing((String s) -> Integer.parseInt(s.split("\\.")[2]))
                .thenComparing(s -> Integer.parseInt(s.split("\\.")[1])).
                thenComparing(s -> Integer.parseInt(s.split("\\.")[0]));


        return admissionList.prijimaciObor.stream()
                .map(admission -> admission.eprDeadlinePrihlaska.value)
                .filter(value -> value != null)
                .distinct().sorted(dateComparator)
                .collect(Collectors.joining(","));
    }
        //return "0";
        // return deadlineList.items.stream().sorted(Comparator.comparing(a -> a.value));
}
