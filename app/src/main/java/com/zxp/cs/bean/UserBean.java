package com.zxp.cs.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;


/**
 * Created by cxf on 2017/8/14.
 */

public class UserBean implements Parcelable {
    protected String id;
    protected String userNiceName;
    protected String avatar;
    protected String avatarThumb;
    protected int sex;
    protected String signature;
    protected String coin;
    protected String votes;
    protected String votesTotal;
    protected String birthday;
    protected int level;
    protected int levelAnchor;
    protected int follows;
    protected int fans;
    protected int auth;//认证状态，0未认证，1认证中，2认证成功，3认证失败
    protected int isAuthorAuth;//是否实名认证
    protected int isUserAuth;//是否实名认证
    protected int onLineStatus;
    protected int isvoice;//是否开启语音
    protected int isvideo;//是否开启视频
    protected String videoPrice;//视频价格
    protected String voicePrice;//语音价格
    protected int isdisturb;//勿扰 是否开启 1开启 0关闭
    protected int isvip;//是否是vip
    protected boolean isattention;//是否关注 true false
    protected int attent;//是否关注 1 关注 0未关注
    protected int attent2;//是否关注 1 关注 0未关注
    protected int isblack;//是否拉黑
    protected String province;
    protected String city;
    protected String identity;
    protected String current_status;
    protected String ismate;

    /**
     * 解释一下，上面两行
     * 在服务端的某些接口里面，关注用 isattent 表示 有些用 u2t 表示，
     * 服务端就要这样弄，没办法，客户端只能这样写
     */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserNiceName() {
        return userNiceName;
    }

    public void setUserNiceName(String userNiceName) {
        this.userNiceName = userNiceName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarThumb() {
        return avatarThumb;
    }

    public void setAvatarThumb(String avatarThumb) {
        this.avatarThumb = avatarThumb;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public String getVotesTotal() {
        return votesTotal;
    }

    public void setVotesTotal(String votesTotal) {
        this.votesTotal = votesTotal;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getLevel() {
        if (level == 0) {
            level = 1;
        }
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevelAnchor() {
        if (levelAnchor == 0) {
            levelAnchor = 1;
        }
        return levelAnchor;
    }

    public void setLevelAnchor(int levelAnchor) {
        this.levelAnchor = levelAnchor;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getAuth() {
        return this.auth;
    }

    public void setAuth(int isAuth) {
        this.auth = isAuth;
    }

    public int getIsUserAuth() {
        return this.isUserAuth;
    }

    public void setIsUserAuth(int mIsUserAuth) {
        this.isUserAuth = mIsUserAuth;
    }

    public int getIsAuthorAuth() {
        return this.isAuthorAuth;
    }

    public void setIsAuthorAuth(int mIsAuthorAuth) {
        this.isAuthorAuth = mIsAuthorAuth;
    }

    public boolean isIsattention() {
        return isattention;
    }

    public void setIsattention(boolean isattention) {
        this.isattention = isattention;
    }

    public int getAttent() {
        return attent;
    }

    public void setAttent(int attent) {
        this.attent = attent;
    }

    public int getAttent2() {
        return attent2;
    }

    public void setAttent2(int attent2) {
        this.attent2 = attent2;
    }

    public int getOnLineStatus() {
        return onLineStatus;
    }

    public void setOnLineStatus(int onLineStatus) {
        this.onLineStatus = onLineStatus;
    }

    public String getVideoPrice() {
        return videoPrice;
    }

    public void setVideoPrice(String videoPrice) {
        this.videoPrice = videoPrice;
    }

    public String getVoicePrice() {
        return voicePrice;
    }

    public void setVoicePrice(String voicePrice) {
        this.voicePrice = voicePrice;
    }

    public int getIsdisturb() {
        return isdisturb;
    }

    public void setIsdisturb(int isdisturb) {
        this.isdisturb = isdisturb;
    }

    public int getIsvip() {
        return isvip;
    }

    public void setIsvip(int isvip) {
        this.isvip = isvip;
    }

    public int getIsblack() {
        return isblack;
    }

    public void setIsblack(int isblack) {
        this.isblack = isblack;
    }

    public int getIsvoice() {
        return isvoice;
    }

    public void setIsvoice(int isvoice) {
        this.isvoice = isvoice;
    }

    public int getIsvideo() {
        return isvideo;
    }

    public void setIsvideo(int isvideo) {
        this.isvideo = isvideo;
    }

    public boolean hasAuth() {
        return this.auth == 1;
    }

    public boolean isFollowing() {
        return this.attent == 1 || this.attent2 == 1;
    }

    public boolean isBlacking() {
        return this.isblack == 1;
    }

    public boolean openVideo() {
        return isvideo == 1;
    }

    public boolean openVoice() {
        return isvoice == 1;
    }

    public boolean openDisturb() {
        return isdisturb == 1;
    }

    public boolean isVip() {
        return this.isvip == 1;
    }

    public boolean isAlAuth() {
        return this.auth == 1;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceCityStr(){
        return province +" " + city;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(String current_status) {
        this.current_status = current_status;
    }

    public String getIsmate() {
        return ismate;
    }

    public String getMateStr(){
        if (TextUtils.isEmpty(ismate)){
            return null;
        }
        if (ismate.equals("1")){
            String result = "WordUtil.getString(R.string.user_mate)";
            if (!TextUtils.isEmpty(identity)){
                result = result + "-" + identity;
            }
            if (!TextUtils.isEmpty(current_status)){
                result = result + "-" + current_status;
            }
            return  result;
        }
        return  null;
    }

    public void setIsmate(String ismate) {
        this.ismate = ismate;
    }

    public UserBean() {
    }

    protected UserBean(Parcel in) {
        this.id = in.readString();
        this.userNiceName = in.readString();
        this.avatar = in.readString();
        this.avatarThumb = in.readString();
        this.sex = in.readInt();
        this.signature = in.readString();
        this.coin = in.readString();
        this.votes = in.readString();
        this.votesTotal = in.readString();
        this.birthday = in.readString();
        this.level = in.readInt();
        this.levelAnchor = in.readInt();
        this.follows = in.readInt();
        this.fans = in.readInt();
        this.auth = in.readInt();
        this.isAuthorAuth = in.readInt();
        this.isUserAuth = in.readInt();
        this.onLineStatus = in.readInt();
        this.isvoice = in.readInt();
        this.isvideo = in.readInt();
        this.videoPrice = in.readString();
        this.voicePrice = in.readString();
        this.isdisturb = in.readInt();
        this.isvip = in.readInt();
        this.isattention = in.readByte()!=0;
        this.attent = in.readInt();
        this.attent2 = in.readInt();
        this.isblack = in.readInt();
        this.province = in.readString();
        this.city = in.readString();
        this.identity = in.readString();
        this.current_status = in.readString();
        this.ismate = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.userNiceName);
        dest.writeString(this.avatar);
        dest.writeString(this.avatarThumb);
        dest.writeInt(this.sex);
        dest.writeString(this.signature);
        dest.writeString(this.coin);
        dest.writeString(this.votes);
        dest.writeString(this.votesTotal);
        dest.writeString(this.birthday);
        dest.writeInt(this.level);
        dest.writeInt(this.levelAnchor);
        dest.writeInt(this.follows);
        dest.writeInt(this.fans);
        dest.writeInt(this.auth);
        dest.writeInt(this.isAuthorAuth);
        dest.writeInt(this.isUserAuth);
        dest.writeInt(this.onLineStatus);
        dest.writeInt(this.isvoice);
        dest.writeInt(this.isvideo);
        dest.writeString(this.videoPrice);
        dest.writeString(this.voicePrice);
        dest.writeInt(this.isdisturb);
        dest.writeInt(this.isvip);
        dest.writeByte((byte) (isattention?1:0));
        dest.writeInt(this.attent);
        dest.writeInt(this.attent2);
        dest.writeInt(this.isblack);
        dest.writeString(this.province);
        dest.writeString(this.city);
        dest.writeString(this.identity);
        dest.writeString(this.current_status);
        dest.writeString(this.ismate);
    }

    public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }

        @Override
        public UserBean createFromParcel(Parcel in) {
            UserBean bean = new UserBean();
            bean.setId(in.readString());
            bean.setUserNiceName(in.readString());
            bean.setAvatar(in.readString());
            bean.setAvatarThumb(in.readString());
            bean.setSex(in.readInt());
            bean.setSignature(in.readString());
            bean.setCoin(in.readString());
            bean.setVotes(in.readString());
            bean.setVotesTotal(in.readString());
            bean.setBirthday(in.readString());
            bean.setLevel(in.readInt());
            bean.setLevelAnchor(in.readInt());
            bean.setFollows(in.readInt());
            bean.setFans(in.readInt());
            bean.setAuth(in.readInt());
            bean.setIsAuthorAuth(in.readInt());
            bean.setIsUserAuth(in.readInt());
            bean.setOnLineStatus(in.readInt());
            bean.setIsvoice(in.readInt());
            bean.setIsvideo(in.readInt());
            bean.setVideoPrice(in.readString());
            bean.setVoicePrice(in.readString());
            bean.setIsdisturb(in.readInt());
            bean.setIsvip(in.readInt());
            bean.setIsattention(in.readByte()!=0);
            bean.setAttent(in.readInt());
            bean.setAttent2(in.readInt());
            bean.setIsblack(in.readInt());
            bean.setProvince(in.readString());
            bean.setCity(in.readString());
            bean.setIdentity(in.readString());
            bean.setCurrent_status(in.readString());
            bean.setIsmate(in.readString());
            return bean;
        }
    };

}
