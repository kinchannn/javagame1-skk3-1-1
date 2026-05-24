import java.awt.image.*;
import java.io.*;

/**
 * 敵スプライト
 * <pre>
 * 敵スプライトオブジェクトとして共通化できる部分を記述します。
 * 爆発処理を行います。
 * <pre>
 */
public class KSpriteT00 extends KSprite {

	/** 爆発フラグ */
	private boolean flgBomb = false;

	/** 爆発時間 */
	private int timeBomb = -1;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageB01 = null;
		BufferedImage imageB02 = null;

		imageB01 = KImage.getImage("image/imageBomb1.gif");
		imageB02 = KImage.getImage("image/imageBomb2.gif");

		KSpriteT00.setImage(KSpriteT00.class, new BufferedImage[]{imageB01, imageB02});

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteT00(KPanel panel){

		super(panel);

	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		if(flgBomb){

			timeBomb++;

			if(timeBomb == 5){
				setImage(KSpriteT00.class, 1);
			}else if(timeBomb == 15){
				setImage(KSpriteT00.class, 0);
			}else if(timeBomb == 20){
				this.removeSprite();
			}

		}

	}

	/**
	 * 爆発
	 */
	public void bomb(){

		flgBomb = true;
		setImage(KSpriteT00.class, 0);

		// 地上物の場合、
		if(this instanceof KSpriteG00){

			// 地上物爆発音スタート
			((KCtrlSKK)panel.getKCtrl()).startWaveJimenBomb();

		// 上記以外の場合、
		}else{

			// 敵爆発音スタート
			((KCtrlSKK)panel.getKCtrl()).startWaveTekiBomb();

		}

	} // end bomb

	/**
	 * 爆発取得
	 */
	public boolean isBomb(){
		return flgBomb;
	}

	/**
	 * 当たり判定
	 * @return true：する ／ false：しない
	 */
	public boolean isHanteiAtari(){
		return true;
	}

}
