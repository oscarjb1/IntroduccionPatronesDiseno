package oscarblancarte.ipb.flyweight.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Oscar Javier Blancarte Iturralde.
 * @see http://www.oscarblancarteblog.com
 */
public class PlayItemFactory {
    public static boolean enableFlyweight = true;
    private static final Map<String,PlayItem> PLAY_ITEMS = new HashMap<>();
    private static Long idSequence = 0L;
    public static PlayItem createPlayItem(String songName){
        if(enableFlyweight && PLAY_ITEMS.containsKey(songName)){
            return PLAY_ITEMS.get(songName);
        }else{
            PlayItem playItem = new PlayItem(++idSequence, songName);
            PLAY_ITEMS.put(songName, playItem);
            return playItem;
        }
    }
}