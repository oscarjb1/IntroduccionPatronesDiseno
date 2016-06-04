package oscarblancarte.ipb.flyweight.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oscar Javier Blancarte Iturralde.
 * @see http://www.oscarblancarteblog.com
 */
public class PlayList {

    private String playListName;
    private List<PlayItem> playItems = new ArrayList<>();

    public PlayList(String playListName) {
        this.playListName = playListName;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public List<PlayItem> getPlayItems() {
        return playItems;
    }

    public void setPlayItems(List<PlayItem> playItems) {
        this.playItems = playItems;
    }

    public void addPlayItem(String songName) {
        playItems.add(PlayItemFactory.createPlayItem(songName));
    }

    public void printList() {
        String out = "\nPlayList > " + playListName;
        for (PlayItem playItem : playItems) {
            out += "\n\t" + playItem.toString();
        }
        System.out.println(out);
    }
}