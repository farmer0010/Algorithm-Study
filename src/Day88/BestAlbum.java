package Day88;

// 베스트 엘범

// 스트리밍 사이트에서 장르별로 가장 많이 재생된 노래를
// 두개씩 모아 베스트 앨범을 출시하려고함
// 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같다

// 1. 속한 노래가 많이 재생된 장르를 먼저 수록한다
// 2. 장르 내에서 많이 재생된 노래를 먼저 수록한다
// 3. 장르 내에서 재생횟수가 같은 노래중에서 고유번호가 낮은 노래를
// 먼저 수록한다.

// 노래와 장르를 나타내는 문자열 배열 genres와 노래별 재생횟수를
// 나타내는 정수배열 plays가 주어질 때 베스트 엘범의 고유 번호를
// 순서대로 return하는 함수를 완성해라

// 샌드박스
// 일단 장르별로 비교할수있게 하나의 클래스를 만들어서 비교해서 정렬시키는 과정이
// 필요하지않을까 생각함
// 그리고나서 생각이 든게 일단 hashmap을 만들어서 장르의 값이 누가 더 큰지 비교하고
// 큰놈을 먼저 보내야할것같은데?


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class BestAlbum {
    class Song implements Comparable<Song>{
        int id;
        int play;

        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
        @Override
        public int compareTo(Song o) {
            if(this.play == o.play){
                return this.id - o.id;
            }
            return o.play - this.play;
        }

    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> generesWin = new HashMap<>();
        HashMap<String, ArrayList<Song>> songs = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            generesWin.put(genres[i], generesWin.getOrDefault(genres[i], 0) + plays[i]);
            songs.putIfAbsent(genres[i], new ArrayList<>());
            songs.get(genres[i]).add(new Song(i, plays[i]));
        }

        ArrayList<String> genreList = new ArrayList<>(generesWin.keySet());
        genreList.sort((a,b) -> generesWin.get(b) - generesWin.get(a)) ;

        ArrayList<Integer> list = new ArrayList<>();
        for(String genre : genreList){
            ArrayList<Song> songList = songs.get(genre);
            Collections.sort(songList);
            list.add(songList.get(0).id);
            if(songList.size() > 1){
                list.add(songList.get(1).id);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
