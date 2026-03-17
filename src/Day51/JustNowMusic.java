package Day51;

// 방금 그곡
// 방금 그곡 서비스는 tv나 라디오 등에서
// 나온 음악에 관해 제목등의 정보제공

// 네오는 자신이 기억한 멜로디를 가지고
// 방금 그곡을 이용해 음악을 찾는다

// 네오가 기억하고 있는 멜로디는 음악의 끝 부분과
// 처음 부분이 이어서 재생된 멜로디 일수도 있고
// 반대로 한 음악을 중간에 끊은 경우 원본
// 음악에는 네오가 기억한 멜로디가 들어있다해도
// 그곡이 네오가 들은 곡이 아닐수도 있다

// 그렇기떄문에 네오는 재생시간과 제공된 악보를
// 직접 보면서 비교하려함

// 방금 그곡 서비스는 음악제목, 재생이 시작되고
// 끝난 시각, 악보제공
// 각 음은 1분에 1개씩 재생됨
// 음악은 반드시 처음부터 재생되며 음악의 길이보다
// 재생된 시간이 길때는 음악이 끊김 없이 처음부터
// 반복해서 재생, 음악 길이보다 재생된 시간이 짧을
// 떄는 처음부터 재생시간 만큼만 재생
// 조건이 일치하는 음악이 여러개 일때는
// 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환
// 재생 시간도 같을 경우 먼저 입력된 음악 제목 반환
// 조건이 일치하는 음악이 없을때는 none 반환

// m은 1개이상 1439개 이하로 구성 (네오가 기억한 멜로디)
// musicinfos (100개 이하 곡정보, 각각
// 곡 정보는 , 음악 시작시간, 종료시간, 제목, 악보정보)
// 음악 시간과 끝나시간은 HH:MM형식

class JustNowMusic {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxStreamTime = -1;

        m = m.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b")
                .replace("E#", "e");

        for (int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            String startTime = info[0];
            String endTime = info[1];
            String title = info[2];
            String music = info[3];

            String[] startSplit = startTime.split(":");
            String[] endSplit = endTime.split(":");
            int start = Integer.parseInt(startSplit[0]) * 60 + Integer.parseInt(startSplit[1]);
            int end = Integer.parseInt(endSplit[0]) * 60 + Integer.parseInt(endSplit[1]);
            int streamTime = end - start;

            music = music.replace("C#", "c")
                    .replace("D#", "d")
                    .replace("F#", "f")
                    .replace("G#", "g")
                    .replace("A#", "a")
                    .replace("B#", "b")
                    .replace("E#", "e");

            StringBuilder playedMusic = new StringBuilder();
            for (int j = 0; j < streamTime; j++) {
                playedMusic.append(music.charAt(j % music.length()));
            }


            if(playedMusic.toString().contains(m))
            {
             if(streamTime > maxStreamTime)
             {
                 answer = title;
                 maxStreamTime = streamTime;
             }
            }
        }

        return answer;
    }
}
