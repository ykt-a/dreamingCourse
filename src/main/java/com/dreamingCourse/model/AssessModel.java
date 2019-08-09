package com.dreamingCourse.model;


import com.dreamingCourse.entity.Ykt_assess;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;

@Data
@Repository
public class AssessModel {
	private String content;
	private int stars;
	private String createTime;
	private String image;

	public static AssessModel init(Ykt_assess assess){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		AssessModel assessModel = new AssessModel();
		assessModel.content = assess.getContent();
		assessModel.stars = assess.getStars();
		assessModel.createTime = simpleDateFormat.format(assess.getCreateTime());
		assessModel.image = assess.getImage();
		return assessModel;
	}
}
