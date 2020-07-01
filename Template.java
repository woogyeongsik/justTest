package com.bpnsolution.jubo.model;

import javax.persistence.*;

import com.bpnsolution.jubo.model.history.TemplateInsUpdInfo;

import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


/**
 * @author : 우경식
 * @description : TEMPLATE 테이블 작성
 * @since :  2020-05-13
 */
@Entity @Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_TEMPLATE")
@Transactional
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long template_idx;        // 템플릿 인덱스

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "church_id", referencedColumnName = "church_id")
    private Church church_id; // 교회 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "bulletin_idx", referencedColumnName = "bulletin_idx")
    private Bulletin bulletin_idx;  // 주보 IDX

    @Column
    private int bulletin_order;    // 주보 순서

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "template_idx")
	private List <Object> object = new ArrayList<Object>();

    @Column(length = 50, nullable = false)
    private String template_title;  // 템플릿 명

	@Column(length = 10)
	private String template_type;

	@Column(length = 10)
	private String background_color;

	@Column
	private int opacity;

	@Column
	private int width;

	@Column
	private int height;

	@Column
	private int zindex;

    @Embedded
    private TemplateInsUpdInfo history;

	public void setTemplate_idx(Long template_idx) {
		this.template_idx = template_idx;
	}

	public void setTemplate_type(String template_type) {
		this.template_type = template_type;
	}

	public void setBackground_color(String background_color) {
		this.background_color = background_color;
	}

	public void setOpacity(int opacity) {
		this.opacity = opacity;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setZindex(int zindex) {
		this.zindex = zindex;
	}

	public void setBulletin_order(int bulletin_order) {
		this.bulletin_order = bulletin_order;
	}

	public void setTemplate_title(String template_title) {
		this.template_title = template_title;
	}

	public void setHistory(TemplateInsUpdInfo history) {
		this.history = history;
	}

	public void setChurch_id(Church church_id) {
		this.church_id = church_id;
	}

	public void setBulletin_idx(Bulletin bulletin_idx) {
		this.bulletin_idx = bulletin_idx;
	}

	protected Church getChurch_id() {
		return church_id;
	}

	public Bulletin getBulletin_idx() {
		return bulletin_idx;
	}



}
