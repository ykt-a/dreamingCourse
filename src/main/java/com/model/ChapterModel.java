package com.model;


import com.entity.Ykt_list;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class ChapterModel {
	private int chapter;
	private int node;
	private String videoLink;
	private String name;

	public static ChapterModel initAll(Ykt_list ykt_list){
		ChapterModel chapterModel = new ChapterModel();
		chapterModel.chapter = ykt_list.getChapter();
		chapterModel.node = ykt_list.getNode();
		chapterModel.videoLink = ykt_list.getVideoLink();
		chapterModel.name = ykt_list.getName();
		return  chapterModel;
	}

	public static ChapterModel init(Ykt_list ykt_list){
		ChapterModel chapterModel = new ChapterModel();
		chapterModel.chapter = ykt_list.getChapter();
		chapterModel.node = ykt_list.getNode();
		chapterModel.name = ykt_list.getName();
		return chapterModel;
	}
}
