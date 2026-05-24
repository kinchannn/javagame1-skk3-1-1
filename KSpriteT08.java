import java.awt.image.*;
import java.io.*;

/**
 * 敵８
 */
public class KSpriteT08 extends KSpriteT00 implements KConstant {

	/** X方向移動量 */
	private int mX = 0;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageT08_00 = null;
		BufferedImage imageT08_01 = null;

		imageT08_00 = KImage.getImage("image/imageT08_00.gif");
		imageT08_01 = KImage.getImage("image/imageT08_01.gif");

		KSpriteT08.setImage(KSpriteT08.class, new BufferedImage[]{
			imageT08_00,
			imageT08_01
		});

	} // end initImage

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 */
	public KSpriteT08(KPanel panel){

		super(panel);

		// X位置を設定
		intX = (int)(Math.random() * (WIDTH - getWidth()));

		intY = -getHeight();

		// X方向移動量を設定
		mX = 4 - (int)(Math.random() * 8);

	} // end KSpriteT08

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

		// 親クラスは実行しない
		// 爆発する必要はないので、親クラスは呼び出さない

		// （コメントの上のコメント）
		// それなら、敵クラス（T00）を継承する必要もあるのか？
		// という疑問が浮かんでくるかもしれない。
		// 自機から見ると、敵だという扱いはしないといけないため。
		// KSpriteShipのrunメソッドで、T00に対して衝突の処理をしている。
		// そのため、敵クラス（T00）である必要があるのだ。

		// 前進
		intY = intY + 12;

		intX = intX + mX;

		// 画面の外に出た場合、
		if(intY > HEIGHT){
			// スプライトを消す
			super.removeSprite();
		}

		// 雷のようなエネルギーの高いイメージを出すために、イメージを変更する。
		if(intY > 396){
			setImage(KSpriteT08.class, 0);
		}else if(intY > 360){
			setImage(KSpriteT08.class, 1);
		}else if(intY > 156){
			setImage(KSpriteT08.class, 0);
		}else if(intY > 120){
			setImage(KSpriteT08.class, 1);
		}

	} // end run

	/**
	 * 爆発
	 */
	public void bomb(){

		//
		// スーパーを呼び出さず、爆発させない
		//

		// T08吸い込み音スタート
		((KCtrlSKK)panel.getKCtrl()).startWaveT08Imbibe();

	} // end bomb

}
