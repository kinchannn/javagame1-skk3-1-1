import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 地上物 32ドット 破壊可能
 */
public class KSpriteG38 extends KSpriteG00 implements KConstant {

	/** 方向 */
	private	static final int			UP			= 1;
	private	static final int			DOWN		= 2;
	private	static final int			LEFT		= 3;
	private	static final int			RIGHT		= 4;

	/** 移動パターン */
	private			int[][]				PATSS		= new int[][]{
		{RIGHT	,  4 * 32},
		{DOWN	,  2 * 32},
		{RIGHT	, 13 * 32},
		{DOWN	, 15 * 32},
		{LEFT	,  2 * 32},
		{UP		,  6 * 32},
		{LEFT	,  4 * 32},
		{DOWN	,  6 * 32},
		{LEFT	,  3 * 32},
		{UP		,  6 * 32},
		{LEFT	,  3 * 32},
		{DOWN	,  6 * 32},
		{LEFT	,  2 * 32},
		{UP		,  4 * 32},
		{LEFT	,  3 * 32},
		{UP		, 13 * 32}
	};

	/** 位置 */
	private			int					pos1		= 0;
	private			int					pos2		= 0;

	/** 被弾数 */
	private			int					hidan		= 0;

	/** スプライトグループ */
	private			KSpriteGroup		spriteGroup	= null;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageG38 = null;

		imageG38 = KImage.getImage("image/imageG37.gif");

		KSpriteG38.setImage(KSpriteG38.class, imageG38);

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteG38(KPanel panel, int pat, KSpriteGroup spriteGroup){

		super(panel);

		// スプライトグループが J40 でも J45 でもない場合、
		if(!(spriteGroup instanceof KSpriteGroupJ40) && !(spriteGroup instanceof KSpriteGroupJ45)){
			// エラーをスロー
			throw new IllegalStateException("スプライトグループが不正です。");
		}

		this.intY = -600 - 64 - 8;

		switch(pat){

			case 0:
				this.intX =  0 * 32;
				this.intY =  0 * 32 + this.intY;
				this.pos1 =  0;
				this.pos2 =  0 * 32;
				break;

			case 1:
				this.intX =  7 * 32;
				this.intY =  2 * 32 + this.intY;
				this.pos1 =  2;
				this.pos2 =  3 * 32;
				break;

			case 2:

				this.intX = 17 * 32;
				this.intY =  2 * 32 + this.intY;
				this.pos1 =  3;
				this.pos2 =  0 * 32;
				break;

			case 3:

				this.intX = 17 * 32;
				this.intY =  9 * 32 + this.intY;
				this.pos1 =  3;
				this.pos2 =  7 * 32;
				break;

			case 4:

				this.intX = 17 * 32;
				this.intY = 17 * 32 + this.intY;
				this.pos1 =  4;
				this.pos2 =  0 * 32;

				break;

			case 5:

				this.intX = 11 * 32;
				this.intY = 11 * 32 + this.intY;
				this.pos1 =  7;
				this.pos2 =  0 * 32;

				break;

			case 6:

				this.intX =  8 * 32;
				this.intY = 17 * 32 + this.intY;
				this.pos1 =  9;
				this.pos2 =  0 * 32;

				break;

			case 7:

				this.intX =  5 * 32;
				this.intY = 11 * 32 + this.intY;
				this.pos1 = 11;
				this.pos2 =  0 * 32;

				break;

			case 8:

				this.intX =  3 * 32;
				this.intY = 13 * 32 + this.intY;
				this.pos1 = 14;
				this.pos2 =  0 * 32;

				break;

			case 9:

				this.intX =  0 * 32;
				this.intY =  9 * 32 + this.intY;
				this.pos1 = 15;
				this.pos2 =  4 * 32;

				break;

		}

		// スプライトグループを保持
		this.spriteGroup = spriteGroup;

	} // end KSpriteG38

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		// スーパークラスを呼び出す
		// 移動はスーパークラスで制御
		super.run();

		// パターン取得
		int[] pats = PATSS[pos1];

		// 方向
		int dir = pats[0];
		// 移動量
		int movement = pats[1];

		// 方向により処理を分ける
		switch(dir){

			// 上の場合、
			case UP:
				// 移動
				intY = intY - 4;
				// ブレイク
				break;

			// 下の場合、
			case DOWN:
				// 移動
				intY = intY + 4;
				// ブレイク
				break;

			// 左の場合、
			case LEFT:
				// 移動
				intX = intX - 4;
				// ブレイク
				break;

			// 右の場合、
			case RIGHT:
				// 移動
				intX = intX + 4;
				// ブレイク
				break;

		} // end switch 方向により処理を分ける

		// ポジション移動
		pos2 = pos2 + 4;

		// 移動が完了した場合、
		if(pos2 >= movement){

			// 移動パターン変更
			pos1++;
			pos1 = (pos1 < PATSS.length)?pos1: 0;

			// ポジション初期化
			pos2 = 0;

		}

	} // end run

	/**
	 * 爆発
	 */
	public void bomb(){

		// 被弾数＋１
		hidan++;

		// 被弾数が8未満の場合、
		if(hidan < 8){

			// 耐える音
			((KCtrlSKK)panel.getKCtrl()).startWaveTekiTaeru();

			// リターン
			return;

		}

		((KCtrlSKK)panel.getKCtrl()).addScore(400);

		super.bomb();

	} // end bomb

}
