// max{}
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
    	Arrays.sort(houses);
    	Arrays.sort(heaters);
    	int sIx=-1;
    	int bIx=-1;
    	int radius=0;
    	for(int i=0; i<houses.length; i++){
    		// find the index of a heater whose position is just smaller than house[i](the last small)
    		int j=(sIx==-1?0:sIx);
    		// clean the record
    		sIx=-1;
    		bIx=-1;
    		for(; j<heaters.length&&heaters[j]<houses[i]; j++){
    			sIx=j;
    		}
    		if(j<heaters.length)	bIx=j;
    		int minDis=0;
    		if(sIx!=-1&&bIx!=-1){// both exist
    			minDis=Math.min(houses[i]-heaters[sIx], heaters[bIx]-houses[i]);
    		}else if(sIx!=-1){// sIx exists
    			minDis=houses[i]-heaters[sIx];
    		}else{
    			minDis=heaters[bIx]-houses[i];
    		}
    		if(minDis>radius)	radius=minDis;
    	}
    	return radius;
    }
}
