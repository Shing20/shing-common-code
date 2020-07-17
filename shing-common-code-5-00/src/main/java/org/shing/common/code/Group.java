package org.shing.common.code;

import java.io.Serializable;

/**
 * @ClassName: Group
 * @Description: Group
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-17 12:12:16
 */
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	private String groupCreateId;
	private String groupId;
	private String groupIntro;
	private String groupName;
	private String groupPhoto;
	private String groupType;
	private String joinGroupVerify;
	private String maxCount;

	@Override
	public String toString() {
		return "toStringTest [groupCreateId=" + groupCreateId + ", groupId=" + groupId + ", groupName=" + groupName
				+ ", groupPhoto=" + groupPhoto + ", joinGroupVerify=" + joinGroupVerify + ", maxCount=" + maxCount
				+ ", groupIntro=" + groupIntro + "]";
	}

	public String getGroupCreateId() {
		return groupCreateId;
	}

	public void setGroupCreateId(String groupCreateId) {
		this.groupCreateId = groupCreateId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupIntro() {
		return groupIntro;
	}

	public void setGroupIntro(String groupIntro) {
		this.groupIntro = groupIntro;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupPhoto() {
		return groupPhoto;
	}

	public void setGroupPhoto(String groupPhoto) {
		this.groupPhoto = groupPhoto;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getJoinGroupVerify() {
		return joinGroupVerify;
	}

	public void setJoinGroupVerify(String joinGroupVerify) {
		this.joinGroupVerify = joinGroupVerify;
	}

	public String getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(String maxCount) {
		this.maxCount = maxCount;
	}

}
