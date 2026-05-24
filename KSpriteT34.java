import java.awt.*;
import java.awt.image.*;
import java.io.*;

/**
 * 敵３４
 */
public class KSpriteT34 extends KSpriteT00 implements KConstant {

	/** 方向 */
	private		String				dir			= null;

	/** 時間 */
	private		int					time		= 0;

	/** フェーズ */
	private		int					phase		= 0;

	/** 被弾数 */
	private		int					hidan		= 0;

	/** スプライトグループ */
	private		KSpriteGroupT34		spriteGroup	= null;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageT34_UR = null;
		BufferedImage imageT34_UL = null;
		BufferedImage imageT34_DR = null;
		BufferedImage imageT34_DL = null;

		imageT34_UR = KImage.getImage("image/imageT34_UR.gif");
		imageT34_UL = KImage.getImage("image/imageT34_UL.gif");
		imageT34_DR = KImage.getImage("image/imageT34_DR.gif");
		imageT34_DL = KImage.getImage("image/imageT34_DL.gif");

		KSpriteT34.setImage(KSpriteT34.class, new BufferedImage[]{
			imageT34_UR,
			imageT34_UL,
			imageT34_DR,
			imageT34_DL
		});

	} // end initImage

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param dir 方向 UR／UL／DR／DLから指定
	 * @param spriteGroup スプライトグループ
	 */
	public KSpriteT34(KPanel panel, String dir, KSpriteGroupT34 spriteGroup){

		super(panel);

		// 方向を保持
		this.dir = dir;

		// 位置初期化
		this.initPosition();

		// スプライトグループを保持
		this.spriteGroup = spriteGroup;

	} // end KSpriteT34

	/**
	 * 位置初期化
	 */
	public void initPosition(){

		// 方向とイメージを設定
		if("UR".equals(this.dir)){
			intX = 40;
			intY = HEIGHT - this.getHeight();
			setImage(0);

		}else if("UL".equals(this.dir)){
			intX = WIDTH -  this.getWidth();
			intY = HEIGHT - this.getHeight() - 40;
			setImage(1);

		}else if("DR".equals(this.dir)){
			intX = 0;
			intY = 40;
			setImage(2);

		}else if("DL".equals(this.dir)){
			intX = WIDTH -  this.getWidth() -40;
			intY = 0;
			setImage(3);

		}

	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

		// 親クラスを実行する
		super.run();

		// 時間＋１
		time++;

		// フェーズ単位で分ける
		switch(phase){

			case 0:

				// 時間が来たら
				if(time >= 240){

					// フェーズを進める
					phase++;
					// 時間を初期化
					time = 0;

					// レーザーT34
					((KCtrlSKK)panel.getKCtrl()).laserT34();

				}

				// ブレイク
				break;

			case 1:

				// ビーム発射タイミングの場合、
				if(time < 120){

					// ビームを生成
					KSpriteT9B kSpriteT9B = new KSpriteT9B(super.getKPanel(), this, this.dir);
					// スプライト層に追加
					super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT9B);

				}

				// 時間が来たら
				if(time >= 180){
					// フェーズを進める
					phase++;
					// 時間を初期化
					time = 0;
				}

				// ブレイク
				break;

			case 2:

				// 方向とイメージを設定
				if("UR".equals(this.dir)){

					if(time <= 60){
						intX = intX + 2;
						intY = intY - 2;
					}else{
						intX = intX + 4;
						intY = intY - 4;
					}

				}else if("UL".equals(this.dir)){

					if(time <= 60){
						intX = intX - 2;
						intY = intY - 2;
					}else{
						intX = intX - 4;
						intY = intY - 4;
					}

				}else if("DR".equals(this.dir)){

					if(time <= 60){
						intX = intX + 2;
						intY = intY + 2;
					}else{
						intX = intX + 4;
						intY = intY + 4;
					}

				}else if("DL".equals(this.dir)){

					if(time <= 60){
						intX = intX - 2;
						intY = intY + 2;
					}else{
						intX = intX - 4;
						intY = intY + 4;
					}

				}

				if(intX < -getWidth() || intX > WIDTH ||
					intY < -getHeight() || intY > HEIGHT){

					// 一旦離脱
					// （そのままのところにいると、当たり判定されてしまう）
					intX = -100;

					// フェーズを進める
					phase++;
					// 時間を初期化
					time = 0;
				}

				// ブレイク
				break;

			case 3:

				// 時間が来たら
				if(time >= 120){

					// 位置変更
					if("UR".equals(this.dir)){
						this.dir = "DL";
					}else if("UL".equals(this.dir)){
						this.dir = "DR";
					}else if("DR".equals(this.dir)){
						this.dir = "UL";
					}else if("DL".equals(this.dir)){
						this.dir = "UR";
					}

					// 位置初期化
					this.initPosition();

					// フェーズを進める
					phase = 0;
					// 時間を初期化
					time = 0;

				}

				// ブレイク
				break;

			default:

				// ブレイク
				break;

		} // end switch フェーズ単位で分ける

	} // end run

	/**
	 * 表示の必要があれば実行されるメソッド
	 * <pre>
	 * 被弾中は一時的に表示しません。
	 * </pre>
	 */
	public void paint(Graphics g){

		// ワープ中１の場合、
		if(phase == 0){

			// 1秒
			if(time < 60){
				// 点滅
				if(time % 4 < 2){
					// リターン
					// 自機を表示しない
					return;
				}

			// 3秒
			}else if(time < 180){
				// 点滅
				if(time % 10 < 3){
					// リターン
					// 自機を表示しない
					return;
				}

			} // end if

		// ワープ中２の場合、
		}else if(phase == 2){

			// 1秒
			if(time < 60){

				// なにもしない

			// 2.5秒
			}else if(time < 150){

				// 点滅
				if(time % 10 < 3){
					// リターン
					// 自機を表示しない
					return;
				}

			// 2.5秒以上
			}else{
				// リターン
				// 自機を表示しない
				return;

			} // end if

		} // end if

		super.paint(g);

	} // end paint

	/**
	 * 当たり判定
	 */
	@Override
	public boolean isHanteiAtari(){

		// ワープ中１の場合、
		if(phase == 0){

			// 3秒
			if(time < 180){
				// 当たり判定しない
				return false;
			}

		// ワープ中２の場合、
		}else if(phase == 2){

			// 1秒
			if(time > 60){
				// 当たり判定しない
				return false;
			}

		} // end if

		// 当たり判定する
		return true;

	} // end isHanteiAtari

	/**
	 * 爆発
	 */
	public void bomb(){

		// 被弾数＋１
		hidan++;

		// 被弾数が16未満の場合、
		if(hidan < 16){

			// 耐える音
			((KCtrlSKK)panel.getKCtrl()).startWaveTekiTaeru();

			// リターン
			return;

		}

		((KCtrlSKK)panel.getKCtrl()).addScore(500);

		super.bomb();

		// スプライトグループに削除を通知
		spriteGroup.removeSprite();

	} // end bomb

}
