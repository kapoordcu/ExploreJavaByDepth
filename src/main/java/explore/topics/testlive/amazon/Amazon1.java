package explore.topics.testlive.amazon;

import java.util.*;

public class Amazon1 {

    public static void main(String[] args) {
        Amazon1 id = new Amazon1();
        int[] ints = {20, 70, 90, 30, 60, 110};
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, Arrays.stream(ints).boxed().toArray(Integer[]::new));

        int totalSpace = 110;
        System.out.println(id.IDsOfPackages(totalSpace, list));

    }

    ArrayList<Integer> IDsOfPackages(int truckSpace, ArrayList<Integer> packagesSpace) {
        Integer minSavingSpace = 30;
        ArrayList<Integer> listOfIds = new ArrayList<>();
        Map<Integer, Integer> arrayIndexMappingSavedBeforeSorting = new HashMap<>();
        if(truckSpace>minSavingSpace) {
            pickUpLargestPackagePair(truckSpace-minSavingSpace, packagesSpace, arrayIndexMappingSavedBeforeSorting);
            return new ArrayList<>(arrayIndexMappingSavedBeforeSorting.keySet());
        }
        return listOfIds;
    }

    private void pickUpLargestPackagePair(int consumedSpaceCount, ArrayList<Integer> packagesSpace, Map<Integer, Integer> keyValuePair) {
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
