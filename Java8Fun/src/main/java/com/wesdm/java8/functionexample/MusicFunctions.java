package com.wesdm.java8.functionexample;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MusicFunctions {

	static BiFunction<String, List<Album>, List<Album>> byArtist = (name, albums) -> albums.stream().filter(a -> a.getArtist().equals(name))
			.collect(Collectors.toList());

	static BiFunction<String, List<Album>, List<Album>> byTrack = (track, albums) -> albums.stream().filter(a -> a.getTracks().contains(track))
			.collect(Collectors.toList());

	static Function<List<Album>, List<Album>> sortByDate = albums -> albums.stream().sorted((x, y) -> y.getReleaseDate().compareTo(x.getReleaseDate()))
			.collect(Collectors.toList());

	static Function<List<Album>, Optional<Album>> first = a -> a.stream().findFirst();

	static Function<List<Album>, Optional<Album>> newest = first.compose(sortByDate);

	static BiFunction<String, List<Album>, Optional<Album>> newestByArtist = byArtist.andThen(newest);

	static BiFunction<String, List<Album>, List<Album>> byArtistSorted = byArtist.andThen(sortByDate);

	static BiFunction<String, List<Album>, Optional<Album>> newestByTrack = byTrack.andThen(newest);
}

class Album {
	String artist;
	List tracks;
	String releaseDate;

	public String getReleaseDate() {
		return releaseDate;
	}

	String getArtist() {
		return artist;
	}

	List getTracks() {
		return tracks;
	}
}
