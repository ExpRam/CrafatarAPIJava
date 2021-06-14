package io.github.expram;

import io.github.expram.exceptions.InvalidScaleException;
import io.github.expram.exceptions.InvalidSizeException;
import io.github.expram.exceptions.InvalidUUIDException;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class CrafatarUser extends Utils {

    private String nickname;

    public CrafatarUser(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public CrafatarFile getCape(String defaultskin) throws InvalidUUIDException {
        String capeUrl = "https://crafatar.com/capes/" + getUUID(nickname) + "?";
        if(defaultskin != null) {
            capeUrl = capeUrl + "default=" + defaultskin;
        }
        getContent(capeUrl);
        try {
            return new CrafatarFile(capeUrl, ImageIO.read(new URL(capeUrl)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CrafatarFile getSkin(String defaultskin) throws InvalidUUIDException {
        String skinUrl = "https://crafatar.com/skins/" + getUUID(nickname) + "?";
        if(defaultskin != null) {
            skinUrl = skinUrl + "default=" + defaultskin;
        }
        getContent(skinUrl);
        try {
            return new CrafatarFile(skinUrl, ImageIO.read(new URL(skinUrl)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CrafatarFile getBodyRender(int scale, Boolean overlay, String defaultskin) throws InvalidUUIDException, InvalidScaleException {
        String BodyRenderUrl = "https://crafatar.com/renders/body/" + getUUID(nickname) + "?";
        if(defaultskin != null) {
            BodyRenderUrl = BodyRenderUrl + "default=" + defaultskin + "&";
        }
        if(scale != 0) {
            if(scale > 10 || scale < 0) {
                throw new InvalidScaleException("Invalid scale!");
            }
            BodyRenderUrl = BodyRenderUrl + "scale=" + scale + "&";
        }
        if(overlay != false) {
            BodyRenderUrl = BodyRenderUrl + "overlay" + "&";
        }
        getContent(BodyRenderUrl);
        try {
            return new CrafatarFile(BodyRenderUrl, ImageIO.read(new URL(BodyRenderUrl)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CrafatarFile getHeadRender(int scale, Boolean overlay, String defaultskin) throws InvalidUUIDException, InvalidScaleException {
        String HeadRenderUrl = "https://crafatar.com/renders/head/" + getUUID(nickname) + "?";
        if(defaultskin != null) {
            HeadRenderUrl = HeadRenderUrl + "default=" + defaultskin + "&";
        }
        if(scale != 0) {
            if(scale > 10 || scale < 0) {
                throw new InvalidScaleException("Invalid scale!");
            }
            HeadRenderUrl = HeadRenderUrl + "scale=" + scale + "&";
        }
        if(overlay != false) {
            HeadRenderUrl = HeadRenderUrl + "overlay" + "&";
        }
        getContent(HeadRenderUrl);
        try {
            return new CrafatarFile(HeadRenderUrl, ImageIO.read(new URL(HeadRenderUrl)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CrafatarFile getAvatar(int size, Boolean overlay, String defaultskin) throws InvalidUUIDException, InvalidSizeException {
        String AvatarUrl = "https://crafatar.com/avatars/" + getUUID(nickname) + "?";
        if(defaultskin != null) {
            AvatarUrl = AvatarUrl + "default=" + defaultskin + "&";
        }
        if(size != 0) {
            if(size > 512 || size < -1) {
                throw new InvalidSizeException("Invalid size!");
            }
            AvatarUrl = AvatarUrl + "size=" + size + "&";
        }
        if(overlay != false) {
            AvatarUrl = AvatarUrl + "overlay" + "&";
        }
        getContent(AvatarUrl);
        try {
            return new CrafatarFile(AvatarUrl, ImageIO.read(new URL(AvatarUrl)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}