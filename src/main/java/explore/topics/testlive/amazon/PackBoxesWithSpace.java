package explore.topics.testlive.amazon;

import java.util.*;
import java.util.stream.Collectors;

public class PackBoxesWithSpace {

    public static void main(String[] args) {
        PackBoxesWithSpace mainApp = new PackBoxesWithSpace();
        int[] numbers = {20, 70, 90, 30, 60, 110};
        // 20, 30, 60, 70, 90, 110
        // x + y = 80
        //
        int totalSpace = 110;
        int savingSpace = 30;
        List<Integer> numbersList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        System.out.println(mainApp.IDsOfPackages(totalSpace, numbersList));



    }

    ArrayList<Integer> IDsOfPackages(int truckSpace, List<Integer> packagesSpace) {
        Integer minSavingSpace = 30;
        ArrayList<Integer> listOfIds = new ArrayList<>();
        Map<Integer, Integer> arrayIndexMappingSavedBeforeSorting = new HashMap<>();
        if(truckSpace>minSavingSpace) {
            pickUpLargestPackagePair(truckSpace-minSavingSpace, packagesSpace, arrayIndexMappingSavedBeforeSorting);
            return new ArrayList<>(arrayIndexMappingSavedBeforeSorting.keySet());
        }
        return listOfIds;
    }

    private void pickUpLargestPackagePair(int consumedSpaceCount, List<Integer> packagesSpace, Map<Integer, Integer> keyValuePair) {
        List<Integer> originalSortingOrderList = new ArrayList<>(packagesSpace);
        Collections.sort(packagesSpace);
        int i=0, j=packagesSpace.size()-1;
        while (i < j) {
            int shortSizePacket = packagesSpace.get(i);
            int largeSizePacket = packagesSpace.get(j);
            if(shortSizePacket + largeSizePacket == consumedSpaceCount) {
                keyValuePair.put(originalSortingOrderList.indexOf(shortSizePacket), shortSizePacket);
                keyValuePair.put(originalSortingOrderList.indexOf(largeSizePacket), largeSizePacket);
                break;
            } else if(shortSizePacket + largeSizePacket < consumedSpaceCount) {
                i++;
            } else {
                j--;
            }
        }

    }


}
