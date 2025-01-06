class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int time = calcTime(pos);
        int maxTime = calcTime(video_len);
        int opsTime = calcTime(op_start);
        int opeTime = calcTime(op_end);
        
        if (time >= opsTime && time <= opeTime) {
            time = opeTime;
        }
        
        for (String cmd : commands) {
            if ("prev".equals(cmd)) {
                time -= 10;
                if (time < 0) time = 0;
            } else {
                time += 10;
                if (time > maxTime) time = maxTime;
            }
            
            if (time >= opsTime && time <= opeTime) {
                time = opeTime;
            }
        }
        return convTime(time);
    }
                    
    int calcTime(String pos) {
        return Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
    }
    
    String convTime(int time) {
        return String.format("%02d:%02d", (time / 60), (time % 60));
    }
}