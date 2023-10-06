import java.util.*;
class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        String[][] bans = Arrays.stream(banned_id)
            .map(ban -> ban.replace("*", ".")) // .은 정규식에서 아무 문자나 하나를 의미한다.
            .map(ban -> Arrays.stream(user_id) // 정규식으로 변환한 문자열과 일치하는 사용자 아이디를 찾는다.
                 .filter(user -> user.matches(ban))
                 .toArray(String[]::new)) // 찾은 사용자 아이디를 배열로 만든다.
            .toArray(String[][]::new); // 찾은 사용자 아이디들을 배열로 만든다.

        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);

        return banSet.size();
    }
    /**
     * @param index  현재 탐색하고 있는 bans의 인덱스
     * @param banned 현재까지 탐색한 사용자 아이디
     * @param bans   정규식으로 변환한 문자열과 일치하는 사용자 아이디들
     * @param banSet 정규식으로 변환한 문자열과 일치하는 사용자 아이디들의 조합
     */
    private static void count(int index, Set<String> banned, String[][] bans,
      Set<Set<String>> banSet) {
        if (index == bans.length) { // 모든 정규식으로 변환한 문자열과 일치하는 사용자 아이디들을 탐색했으면
            banSet.add(new HashSet<>(banned)); // 정규식으로 변환한 문자열과 일치하는 사용자 아이디들의 조합을 추가한다.
            return;
        }

        for (String ban : bans[index]) { // 정규식으로 변환한 문자열과 일치하는 사용자 아이디들을 탐색한다.
            if (banned.contains(ban)) { // 이미 탐색한 사용자 아이디면
                continue;
            }
            banned.add(ban); // 사용자 아이디를 탐색했다고 표시한다.
            count(index + 1, banned, bans, banSet); // 다음 정규식으로 변환한 문자열과 일치하는 사용자 아이디들을 탐색한다.
            banned.remove(ban); // 사용자 아이디를 탐색했다고 표시를 취소한다.
        }
    }
}