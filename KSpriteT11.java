import java.awt.image.*;
import java.io.*;

/**
 * 敵１１ シンプルブラック
 */
public class KSpriteT11 extends KSpriteT00 implements KConstant {

	/** ビーム発射フラグ */
	private		boolean		flgBeam		= false;

	/** ビーム発射位置 */
	private		int			beamY		= -1;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageT11 = null;

		imageT11 = KImage.getImage("image/imageT11.gif");

		KSpriteT11.setImage(KSpriteT11.class, imageT11);

	} // end initImage

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param pos 編隊ポジション
	 * @param storyParam ビーム発射位置
	 */
	public KSpriteT11(KPanel panel, String storyParam){

		super(panel);

		// X位置：編隊ポジションを設定
		intX = (int)(Math.random() * (WIDTH - this.getWidth()));

		intY = -getHeight();

		// ビーム発射位置が設定されている場合、
		if(storyParam != null){
			beamY = Integer.parseInt(storyParam);
		}

	} // end KSpriteT11

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

		// 親クラスを実行する
		super.run();

		// 前進
		intY = intY + 4;

		// 画面の外に出た場合、
		if(intY > HEIGHT){
			// スプライトを消す
			super.removeSprite();
		}

		// ビームを発射する場合、
		if(!flgBeam && beamY != -1 && intY > beamY){

			// ビーム発射
			flgBeam = true;

			KSpriteT99 kSpriteT99 = new KSpriteT99(super.getKPanel(), this, 2);
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT99);

		} // end if  ビームを発射する場合

	} // end run

	/**
	 * 爆発
	 */
	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(100);

		super.bomb();

	} // end bomb

}
