class Solution {
    public int[] solution(String[] wallpaper) {
        
        int[] answer = new int[] {findR1(wallpaper), findC1(wallpaper), findR2(wallpaper), findC2(wallpaper)};
        return answer;
    }
    
    int findR1(String[] wallpaper) {
        for (int i = 0; i < wallpaper.length; ++i) {
            if (wallpaper[i].contains("#")) {
                return i;
            }
        }
        return -1;
    }
    
    int findC1(String[] wallpaper) {
        for (int j = 0; j < wallpaper[0].length(); ++j) {
            for (int i = 0; i < wallpaper.length; ++i) {
                if (wallpaper[i].charAt(j) == '#') {
                    return j;
                }
            }
        }
        return -1;
    }
    
    int findR2(String[] wallpaper) {
        for (int i = wallpaper.length - 1; i >= 0; --i) {
            if (wallpaper[i].contains("#")) {
                return i + 1;
            }
        }
        return -1;
    }
    
    int findC2(String[] wallpaper) {
        for (int j = wallpaper[0].length() - 1; j >= 0 ; --j) {
            for (int i = 0; i < wallpaper.length; ++i) {
                if (wallpaper[i].charAt(j) == '#') {
                    return j + 1;
                }
            }
        }
        return -1;
    }
}