package com.lmw.domain;

import java.io.Serializable;
import java.util.List;

public class SouHu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long authorId;
	private String authorName;
	private String authorPic;
	private String focus;
	private String picUrl;
	private String images;
	private String title;
	private String mobileTitle;
	private List<Object> tags;
	private Long publicTime;
	private String channelId;
	private String channelUrl;
	private String categoryId;
	private String cmsId;
	private String originalSource;
	private String outerLink;
	private String otherId;
	private String passport;
	private String personalPage;
	private String url;
	private String date;
	private String body;
	private Integer flag;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorPic() {
		return authorPic;
	}

	public void setAuthorPic(String authorPic) {
		this.authorPic = authorPic;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMobileTitle() {
		return mobileTitle;
	}

	public void setMobileTitle(String mobileTitle) {
		this.mobileTitle = mobileTitle;
	}

	public List<Object> getTags() {
		return tags;
	}

	public void setTags(List<Object> tags) {
		this.tags = tags;
	}

	public Long getPublicTime() {
		return publicTime;
	}

	public void setPublicTime(Long publicTime) {
		this.publicTime = publicTime;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelUrl() {
		return channelUrl;
	}

	public void setChannelUrl(String channelUrl) {
		this.channelUrl = channelUrl;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCmsId() {
		return cmsId;
	}

	public void setCmsId(String cmsId) {
		this.cmsId = cmsId;
	}

	public String getOriginalSource() {
		return originalSource;
	}

	public void setOriginalSource(String originalSource) {
		this.originalSource = originalSource;
	}

	public String getOuterLink() {
		return outerLink;
	}

	public void setOuterLink(String outerLink) {
		this.outerLink = outerLink;
	}

	public String getOtherId() {
		return otherId;
	}

	public void setOtherId(String otherId) {
		this.otherId = otherId;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getPersonalPage() {
		return personalPage;
	}

	public void setPersonalPage(String personalPage) {
		this.personalPage = personalPage;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "SouHu [id=" + id + ", authorId=" + authorId + ", authorName=" + authorName + ", authorPic=" + authorPic + ", focus=" + focus + ", picUrl=" + picUrl + ", images=" + images + ", title=" + title + ", mobileTitle=" + mobileTitle + ", tags=" + tags + ", publicTime=" + publicTime + ", channelId=" + channelId + ", channelUrl=" + channelUrl + ", categoryId=" + categoryId + ", cmsId="
				+ cmsId + ", originalSource=" + originalSource + ", outerLink=" + outerLink + ", otherId=" + otherId + ", passport=" + passport + ", personalPage=" + personalPage + ", url=" + url + ", date=" + date + ", body=" + body + ", flag=" + flag + "]";
	}

}
