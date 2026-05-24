import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

/**
 * イメージクラス
 */
public class KImage {

	private static Container con = null;

	/**
	 * コンテナ設定
	 * <pre>
	 * 通常は、当メソッドを呼び出してください。
	 * </pre>
	 * @param con コンテナ
	 */
	public static void setContainer(Container con){
		KImage.con = con;
	}

	/**
	 * イメージをファイルから取り込む
	 * @param fileName Imgaeのファイル名
	 * @return BufferedImage 読み込んだイメージ
	 * @throws IOException ファイルを読み込み中にエラーが発生した場合
	 */
	public static BufferedImage getImage(String fileName) throws IOException {

		// FileInputStreamを生成
		InputStream is = KImage.con.getClass().getResourceAsStream(fileName);

		// イメージを取り込む
		BufferedImage bi = ImageIO.read(is);

		// 閉じる
		is.close();

		// 戻り値に読み込んだイメージをセット
		return bi;

	} // getImage

}
