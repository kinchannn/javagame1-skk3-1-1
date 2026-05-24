# はじめに

きんの世界にようこそ♪
Javaでゲームを作ろう／The Java使いこなす
に興味をもってくれたことに感謝します。

ここでは当プロジェクトをコンパイル＆実行するための手順を記載しています。
当手順を行わないと、コンパイル および 実行ができないことになりかねません。
正しく動作させるために、実行前に必ず以下の準備を行ってください。

当ファイルはGitHubに公開するタイミングで作成しています。
ＨＰ側のモジュールにもそのまま載せてあります。
（2026/05）


## 🚀 Javaのパスを書き換える必要性について － 大事なポイントをおさえよう －

本プロジェクトには、実行環境のセットアップを簡略化するためのバッチファイルが同梱されていますが、
**バッチファイル内に記述されているJava（JDK）のパスは、開発者のローカル環境固有のもの**
となっています。

そのまま実行すると「パスが見つかりません」等のエラーになるため、最初に以下の書き換えを必ず行ってください。


### 1. `sta.bat` の編集
1. `sta.bat` をテキストエディタ（メモ帳など）で開きます。

2. Java（JDK）のパスを設定する。

```bat
C:\Java\jdk-25.0.1\bin
```
と記述されているパスの部分を、
**ご自身のPCにインストールされているJava（JDK）の bin フォルダの絶対パス**
に書き換えて保存します。

3. JavaFXを利用している場合は、以下の見直しもお願いします。

JavaFXは
「Javaでゲームを作ろう３ －JavaFX シューティングゲーム編 －」
「Javaでゲームを作ろう４ －JavaFX ３Ｄゲーム編 －」
で利用しています。その他は利用していないので、ここは読み飛ばしてください。

JavaFXでは、Java以外のモジュールとしてJavaFXを認識させないといけないため、
当修正も必要となります。

```bat
C:\Java\javafx-sdk-25.0.1\lib
```
と記述されているパスの部分を、
**ご自身のPCにインストールされているJavaFXの bin フォルダの絶対パス**
に書き換えて保存します。


## 🛠️ コンパイルと実行の手順

パスの書き換えが完了したら、コマンドプロンプト（またはターミナル）を開き、
対象のフォルダ（ディレクトリ）に移動して以下の順番でバッチファイルを実行してください。

フォルダ内に置いてある Command Prompt を開くと、
そのまま利用可能です。

### ステップ 1：環境のセットアップ
```cmd
sta.bat
```

### ステップ 2：コンパイル（コンパイルが必要な場合）
```cmd
jc.bat
```

### ステップ 3：実行
```cmd
j.bat
```

## ❔ 動かなかった場合

書籍内では、著者に質問できるように問い合わせ先を載せています。
そちらに連絡いただければ、確認させていただきます。

## 💛 参考情報／ホームページリンク

* [きんのサイト](https://kinchannn.jp)
* [共通編（まずは環境構築！）](https://kinchannn.jp/javagame_common/)
* [Javaでゲームを作ろう０（ゼロ）－ ゲーム基本編 －](https://kinchannn.jp/javagame_kihon/)
* [Javaでゲームを作ろう０（ゼロ）－ マウスゲーム編 －](https://kinchannn.jp/javagame_kihon_mouse/)
* [Javaでゲームを作ろう０（ゼロ）－ キーボードゲーム編 －](https://kinchannn.jp/javagame_kihon_keybord/)
* [Javaでゲームを作ろう１－ シューティングゲーム編 －](https://kinchannn.jp/javagame_skk/)
* [Javaでゲームを作ろう２－ パズルゲーム編 －](https://kinchannn.jp/javagame_pzl/)
* [Javaでゲームを作ろう３－ JavaFXシューティングゲーム編 －](https://kinchannn.jp/javagame_skk4/)
* [Javaでゲームを作ろう４－ JavaFX 3Dゲーム編 －](https://kinchannn.jp/javagame_fx3d/)
* [【Java初心者向け】The Java 使いこなす](https://kinchannn.jp/thejava/)





---

# Introduction

Welcome to Kin's World! ♪
Thank you for your interest in "Javaでゲームを作ろう (Let's Make Games in Java)" and "The Java 使いこなす (Mastering The Java)".

This document outlines the common procedures for compiling and running this project.
Failure to follow these steps may prevent the program from compiling or executing correctly.
Please ensure you complete the following preparation before running the application.

This file was created at the time of publication to GitHub.
It is also included as is in the module on the website.
(2026/05)

---

## 🚀 Requirement to Update the Java Path - Key Points to Remember -

This project includes batch files designed to simplify the environment setup. However, **the Java (JDK) path written inside these batch files is specific to the developer's local environment.**

Running them as-is will result in errors such as "Path not found." Therefore, you must modify the path first by following the steps below.

### 1. Editing `sta.bat`
1. Open `sta.bat` with a text editor (such as Notepad).
2. **Set the Java (JDK) Path:**
   Locate the path written as `C:\Java\jdk-25.0.1\bin` and replace it with the **absolute path to the bin folder of the Java (JDK) installed on your PC**, then save the file.
3. **Review for JavaFX (If Applicable):**
   JavaFX is used in "Javaでゲームを作ろう３" and "Javaでゲームを作ろう４". It is not used in other projects, so you can skip this part if it does not apply.
   
   Since JavaFX needs to be recognized as a module outside of standard Java, this additional adjustment is required.
   Locate the path written as `C:\Java\javafx-sdk-25.0.1\lib` and replace it with the **absolute path to the lib folder of the JavaFX installed on your PC**, then save the file.

---

## 🛠️ Compilation and Execution Steps

Once the path has been updated, open the Command Prompt (or Terminal), navigate to the target folder (directory), and execute the batch files in the following order:

Opening the Command Prompt located in the folder will allow you to use it immediately.

### Step 1: Environment Setup
```cmd
sta.bat
```

### Step 2: Compilation (If compilation is required)
```cmd
jc.bat
```

### Step 3: Execution
```cmd
j.bat
```

## ❔ If it Doesn't Work

The book includes contact information for reaching out to the author.
If you contact me through those channels, I will gladly check the issue for you.

## 💛 Reference Info / Homepage Links

* [Kin's Website](https://kinchannn.jp)
* [Common Setup Guide](https://kinchannn.jp/javagame_common/)
* [Let's make a game in Java 0(ZERO) - Basic Game -](https://kinchannn.jp/javagame_kihon/)
* [Let's make a game in Java 0(ZERO) - Mouse Game -](https://kinchannn.jp/javagame_kihon_mouse/)
* [Let's make a game in Java 0(ZERO) - Keyboard Game -](https://kinchannn.jp/javagame_kihon_keybord/)
* [Let's make a game in Java 1 - Shooting Game -](https://kinchannn.jp/javagame_skk/)
* [Let's make a game in Java 2 - Puzzle Game -](https://kinchannn.jp/javagame_pzl/)
* [Let's make a game in Java 3 - JavaFX Shooting Game -](https://kinchannn.jp/javagame_skk4/)
* [Let's make a game in Java 4 - JavaFX 3D Game -](https://kinchannn.jp/javagame_fx3d/)
* [【For Java Beginners】Mastering the Java](https://kinchannn.jp/thejava/)

