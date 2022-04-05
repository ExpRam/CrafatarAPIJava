# CrafatarAPI

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.expram/CrafatarAPI/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.expram/CrafatarAPI)

* [Crafatar Api](https://crafatar.com/) For Java
* This Libary Using [java-json](http://www.java2s.com/Code/Jar/j/Downloadjavajsonjar.htm)

## Example Usage

```java
    public static void main(String[] args) {
        try {
            new CrafatarUser("superplays_")
                    //If you don't want to change scale, size and etc, use 'null'
                    .getAvatar(512, true, null)
                    //If you need a url - use the getUrl method
                    .download("D:\\image\\\, "avatar");
        } catch (InvalidUUIDException | InvalidSizeException e) {
            e.printStackTrace();
        }
    }
```
## Sample code for getting the player's body

```java
    public static void main(String[] args) {
        try {
            new CrafatarUser("superplays_")
                    .getBodyRender(10, false, null)
                    .download("D:\\image\\", "body");
        } catch (InvalidUUIDException | InvalidScaleException e) {
            e.printStackTrace();
        }
    }
```

## Sample code for getting the player's head

```java
    public static void main(String[] args) {
        try {
            new CrafatarUser("superplays_")
                    .getHeadRender(10, false, null)
                    .download("D:\\image\\", "head");
        } catch (InvalidUUIDException | InvalidScaleException e) {
            e.printStackTrace();
        }
    }
```

## Sample code for getting the player's skin

```java
    public static void main(String[] args) {
        try {
            new CrafatarUser("superplays_")
                    .getSkin(null)
                    .download("D:\\image\\", "avatar");
        } catch (InvalidUUIDException e) {
            e.printStackTrace();
        }
    }
```

## Sample code for getting the player's cape

```java
    public static void main(String[] args) {
        try {
            new CrafatarUser("jeb_")
                    .getCape(null)
                    .download("D:\\image\\", "cape");
        } catch (InvalidUUIDException e) {
            e.printStackTrace();
        }
    }
```
