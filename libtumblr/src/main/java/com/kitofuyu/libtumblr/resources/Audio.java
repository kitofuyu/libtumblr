package com.kitofuyu.libtumblr.resources;

public class Audio extends Post{
    private String caption;
    private String player;
    private long plays;
    private String album_art;
    private String artist;
    private String album;
    private String track_name;
    private long track_number;
    private long year;
    
    /**
     * get the user-supplied caption
     * @return
     */
    public String getCaption() {
        return caption;
    }
    
    /**
     * set the user's caption
     * @param caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    /**
     * get the HTML for embedding the audio player
     * @return
     */
    public String getPlayer() {
        return player;
    }
    
    /**
     * set the HTML for embedding the audio player
     * @param player
     */
    public void setPlayer(String player) {
        this.player = player;
    }
    
    /**
     * get number of times the audio post has been played
     * @return
     */
    public long getPlays() {
        return plays;
    }
    
    /**
     * set number of times the audio post has been played
     * @param plays
     */
    public void setPlays(long plays) {
        this.plays = plays;
    }
    
    /**
     * get the location of the audio file's ID3 album art image
     * @return
     */
    public String getAlbumArt() {
        return album_art;
    }
    
    /**
     * set the location of the audio file's ID3 album art image
     * @param album_art
     */
    public void setAlbumArt(String albumArt) {
        this.album_art = albumArt;
    }
    
    /**
     * get the audio file's ID3 artist value
     * @return
     */
    public String getArtist() {
        return artist;
    }
    
    /**
     * set the audio file's ID3 artist value
     * @param artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    /**
     * get the audio file's ID3 album value
     * @return
     */
    public String getAlbum() {
        return album;
    }
    
    /**
     * set the audio file's ID3 album value
     * @param album
     */
    public void setAlbum(String album) {
        this.album = album;
    }
    
    /**
     * get the audio file's ID3 title value
     * @return
     */
    public String getTrackName() {
        return track_name;
    }
    
    /**
     * set the audio file's ID3 title value
     * @param trackName
     */
    public void setTrackName(String trackName) {
        this.track_name = trackName;
    }
    
    /**
     * get the audio file's ID3 track value
     * @return
     */
    public long getTrackNumber() {
        return track_number;
    }
    
    /**
     * set the audio file's ID3 track value
     * @param trackNumber
     */
    public void setTrackNumber(long trackNumber) {
        this.track_number = trackNumber;
    }
    
    /**
     * get the audio file's ID3 year value
     * @return
     */
    public long getYear() {
        return year;
    }
    
    /**
     * set the audio file's ID3 year value
     * @param year
     */
    public void setYear(long year) {
        this.year = year;
    }
    
}
