package com.bpnsolution.jubo.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bpnsolution.jubo.model.history.ObjectInsUpdInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * @author : 우경식
 * @description : OBJECT 테이블 작성
 * @since :  2020-05-13
 */

@Entity @Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_OBJECT")
public class Object {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long object_idx;	// 구성요소 인덱스

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "church_id", referencedColumnName = "church_id")
    private Church church_id;	// 교회 id

    //@Column(nullable = false)
    //private Long template_idx;	// 템플릿 idx

    @Column(nullable = false, length = 6)
    private String template_type;	// 템플릿 종류

    @Column(nullable = false, length = 6)
    private String object_type;	// 구성요소 종류

    @Column
    private int object_x_axis;	// 구성요소 x축 값

    @Column
    private int object_y_axis;	// 구성요소 y축 값

    @Column
    private int object_width;	// 구성요소 너비

    @Column
    private int object_height;	// 구성요소 높이

	@Column(length = 400)
	private String image_src;	// 이미지 소스

	@Column(length = 50)
	private String font_groups;	// 글자 형태

	@Column(length = 20)
	private String font_name;	// 글자 폰트명

	@Column(length = 10)
	private String font_size;	// 글자 크기

	@Column(length = 10)
	private String font_color;	// 글자 색상

	@Column(length = 10)
	private String background_color; // 배경 색상

	@Column
	private int opacity;		// 투명도

	@Lob
	private String text;		// 문자 내용

	@Column(length = 10)
	private String text_align;	// 문자 정렬

	@Column
	private LocalDateTime date;	// 일정 일자

	@Column
	private LocalDateTime start_time;	// 일정 시작 시간

	@Column
	private LocalDateTime end_time;	// 일정 종료 시간

	@Column(length = 100)
	private String title;	// 일정 제목

	@Column(length = 200)
	private String de;	// 일정 상세

    @Embedded
    private ObjectInsUpdInfo history;

	public void setObject_idx(Long object_idx) {
		this.object_idx = object_idx;
	}

	//public void setTemplate_idx(Long template_idx) {
	//	this.template_idx = template_idx;
	//}

	public void setTemplate_type(String template_type) {
		this.template_type = template_type;
	}

	public void setObject_type(String object_type) {
		this.object_type = object_type;
	}

	public void setObject_x_axis(int object_x_axis) {
		this.object_x_axis = object_x_axis;
	}

	public void setObject_y_axis(int object_y_axis) {
		this.object_y_axis = object_y_axis;
	}

	public void setObject_width(int object_width) {
		this.object_width = object_width;
	}

	public void setObject_height(int object_height) {
		this.object_height = object_height;
	}

	public void setHistory(ObjectInsUpdInfo history) {
		this.history = history;
	}

	public void setChurch_id(Church church_id) {
		this.church_id = church_id;
	}

	public void setImage_src(String image_src) {
		this.image_src = image_src;
	}

	public void setFont_groups(String font_groups) {
		this.font_groups = font_groups;
	}

	public void setFont_name(String font_name) {
		this.font_name = font_name;
	}

	public void setFont_size(String font_size) {
		this.font_size = font_size;
	}

	public void setFont_color(String font_color) {
		this.font_color = font_color;
	}

	public void setBackground_color(String background_color) {
		this.background_color = background_color;
	}

	public void setOpacity(int opacity) {
		this.opacity = opacity;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setText_align(String text_align) {
		this.text_align = text_align;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}

	public void setEnd_time(LocalDateTime end_time) {
		this.end_time = end_time;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDesc(String de) {
		this.de = de;
	}

	public Object saveObject(Object saveobject) {
		Object object = new Object();
		object.setChurch_id(saveobject.getChurch_id());
		object.setHistory(saveobject.getHistory());
		object.setObject_type(saveobject.getObject_type());
		object.setObject_height(saveobject.getObject_height());
		object.setObject_width(saveobject.getObject_width());
		object.setObject_x_axis(saveobject.getObject_x_axis());
		object.setObject_y_axis(saveobject.getObject_y_axis());
		//object.setTemplate_idx(saveobject.getTemplate_idx());
		object.setTemplate_type(saveobject.getTemplate_type());
		object.setOpacity(saveobject.getOpacity());
		object.setDate(saveobject.getDate());
		object.setText(saveobject.getText());
		object.setText_align(saveobject.getText_align());
		object.setStart_time(saveobject.getStart_time());
		object.setEnd_time(saveobject.getEnd_time());
		object.setTitle(saveobject.getTitle());
		object.setBackground_color(object.getBackground_color());
		object.setDesc(saveobject.getDe());
		object.setFont_color(saveobject.getFont_color());
		object.setFont_groups(saveobject.getFont_groups());
		object.setFont_name(saveobject.getFont_name());
		object.setFont_size(saveobject.getFont_size());
		object.setImage_src(saveobject.getImage_src());
		return object;
	}

	@Override
	public String toString() {
		return "Object{" +
				"object_idx=" + object_idx +
				", church_id=" + church_id +
				//", template_idx=" + template_idx +
				", template_type='" + template_type + '\'' +
				", object_type='" + object_type + '\'' +
				", object_x_axis=" + object_x_axis +
				", object_y_axis=" + object_y_axis +
				", object_width=" + object_width +
				", object_height=" + object_height +
				", image_src='" + image_src + '\'' +
				", font_groups='" + font_groups + '\'' +
				", font_name='" + font_name + '\'' +
				", font_size='" + font_size + '\'' +
				", font_color='" + font_color + '\'' +
				", background_color='" + background_color + '\'' +
				", opacity=" + opacity +
				", text='" + text + '\'' +
				", text_align='" + text_align + '\'' +
				", date=" + date +
				", start_time=" + start_time +
				", end_time=" + end_time +
				", title='" + title + '\'' +
				", de='" + de + '\'' +
				", history=" + history +
				'}';
	}
}
