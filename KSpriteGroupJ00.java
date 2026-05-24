/**
 * 地面共通
 */
public class KSpriteGroupJ00 extends KSpriteGroup implements KConstant {

	/** 移動ストップフラグ */
	private			boolean		flgStopMove		= false;

	/** 残機 */
	private			int			remaining		= 0;

	private			int			intX			= 0;

	/**
	 * コンストラクタ
	 */
	public KSpriteGroupJ00(KPanel panel){

		super(panel);

	}

	/**
	 * X位置設定
	 * <pre>
	 * 最初のX位置を変更したい場合は、このメソッドで定義してください。
	 * <pre>
	 * @param intX X
	 */
	public void setX(int intX){
		this.intX = intX;
	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。（通常は）
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){
	}

	/**
	 * スプライト配置
	 * @param js 地面データ
	 */
	public void haitiSprite(int[] js){

		// 地面データ数を取得
		int countJs = js.length;

		// 地面データ数分、ループ
		for(int i = 0; i < countJs; i = i + 2){

			// 位置取得
			int mx = js[i];

			// 地面種類取得
			int j = js[i + 1];

			// スプライト
			KSprite kSprite = null;

			// 種類により分岐
			switch(j){

				// 地面 32ドット 破壊不可
				case J01:
				case J02:
				case J03:
				case J05:
				case J06:
				case J07:
				case J08:
				case J11:
				case J12:
				case J21:
				case J22:

					// スプライトを生成
					kSprite = new KSpriteJ01(super.getKPanel(), intX + mx * 32, j);

					// スプライトを追加
					super.getKPanel().addSprite(LAYOUT_JIMEN_0, kSprite);

					// ブレイク
					break;

				// 地面 32ドット 破壊不可
				case J31:
				case J32:
				case J33:
				case J34:
				case J35:
				case J36:

					// スプライトを生成
					kSprite = new KSpriteJ31(super.getKPanel(), intX + mx * 32, j);

					// スプライトを追加
					super.getKPanel().addSprite(LAYOUT_JIMEN_0, kSprite);

					// ブレイク
					break;

				// 地面 プリセット基盤 破壊不可
				case J41_0:
				case J41_1:

					// スプライトを生成
					kSprite = new KSpriteJ41(super.getKPanel(), intX + mx * 32, j);

					// スプライトを追加
					super.getKPanel().addSprite(LAYOUT_JIMEN_0, kSprite);

					// ブレイク
					break;

				// 地面 ヒエログリフ 破壊不可
				case J42_0:
				case J42_1:

					// スプライトを生成
					kSprite = new KSpriteJ42(super.getKPanel(), intX + mx * 32, j);

					// スプライトを追加
					super.getKPanel().addSprite(LAYOUT_JIMEN_0, kSprite);

					// ブレイク
					break;

				// 地面 32ドット 破壊可能 アニメ
				case G01:

					// スプライトを生成
					kSprite = new KSpriteG01(super.getKPanel(), intX + js[i] * 32);

					// スプライトを追加
					super.getKPanel().addSprite(LAYOUT_JIMEN_1, kSprite);

					// ブレイク
					break;

				// 地面 64ドット 破壊可能
				case G11:
				case G12:

					// スプライトを生成
					kSprite = new KSpriteG11(super.getKPanel(), intX + js[i] * 32, j);

					// スプライトを追加
					super.getKPanel().addSprite(LAYOUT_JIMEN_1, kSprite);

					// ブレイク
					break;

				// 地面 32ドット 破壊可能 CPU
				case G31:
				case G32_0:
				case G32_1:
				case G32_2:
				case G32_3:
				case G33:
				case G34:
				case G35:
				case G36:

					// スプライトを生成
					kSprite = new KSpriteG31(super.getKPanel(), intX + mx * 32, j);

					// スプライトを追加
					super.getKPanel().addSprite(LAYOUT_JIMEN_1, kSprite);

					// ブレイク
					break;

				// 地面 64×32ドット 破壊可能 CPU
				case G41:

					// スプライトを生成
					kSprite = new KSpriteG41(super.getKPanel(), intX + mx * 32);

					// スプライトを追加
					super.getKPanel().addSprite(LAYOUT_JIMEN_1, kSprite);

					// ブレイク
					break;

				// 地面 32×64ドット 破壊可能 CPU
				case G51:
				case G52:

					// スプライトを生成
					kSprite = new KSpriteG51(super.getKPanel(), intX + mx * 32, j);

					// スプライトを追加
					super.getKPanel().addSprite(LAYOUT_JIMEN_1, kSprite);

					// ブレイク
					break;

				// 地面 64ドット 破壊可能 アニメ
				case G61:

					// スプライトを生成
					kSprite = new KSpriteG61(super.getKPanel(), intX + mx * 32);

					// スプライトを追加
					super.getKPanel().addSprite(LAYOUT_JIMEN_1, kSprite);

					// ブレイク
					break;

				// 地面 64ドット 破壊可能 CPU
				case G62:
				case G63:

					// スプライトを生成
					kSprite = new KSpriteG62(super.getKPanel(), intX + mx * 32, j);

					// スプライトを追加
					super.getKPanel().addSprite(LAYOUT_JIMEN_1, kSprite);

					// ブレイク
					break;

				// 地面 64ドット 破壊可能 シャチホコ
				case G64:

					// スプライトを生成
					kSprite = new KSpriteG64(super.getKPanel(), intX + js[i] * 32);

					// スプライトを追加
					super.getKPanel().addSprite(LAYOUT_JIMEN_1, kSprite);

					// ブレイク
					break;

				// 地面 128ドット 破壊可能 CPU
				case G71:
				case G72:

					// スプライトを生成
					kSprite = new KSpriteG71(super.getKPanel(), intX + mx * 32, j);

					// スプライトを追加
					super.getKPanel().addSprite(LAYOUT_JIMEN_1, kSprite);

					// ブレイク
					break;

				default:

					// ブレイク
					break;

			} // end switch 種類により分岐

			// スプライトグループが J40 または J45 の場合、
			if(this instanceof KSpriteGroupJ40 || this instanceof KSpriteGroupJ45){

				// スプライトが存在する場合、
				if(kSprite != null){

					// スプライトグループを設定
					((KSpriteJ00)kSprite).setSpriteGroup(this);

					// スプライトがG系の場合、
					if(kSprite instanceof KSpriteG00){

						// 残機＋１
						remaining++;

					} 

				} // end if スプライトが存在する場合

			} // end if スプライトグループが J40 または J45 の場合

		} // end for 地面データ数分、ループ

	} // end haitiSprite

	/**
	 * スプライト追加（残機＋１）
	 * <pre>
	 * 下記の場合（AND条件）、当メソッドを呼び出してください。
	 * ・スプライトグループとして移動をストップする場合
	 * ・スプライトをサブクラスで追加した場合
	 * <pre>
	 */
	protected void addSprite(){
		// 残機＋１
		remaining++;
	}

	/**
	 * 移動ストップ
	 * <pre>
	 * 移動を停止します。
	 * <pre>
	 */
	public void stopMove(){

		// 移動ストップ
		flgStopMove = true;

		// ストーリーを停止する
		((KCtrlSKK)panel.getKCtrl()).getKStory().stop();

	} // stopMove

	/**
	 * 移動可能判定
	 * <pre>
	 * 移動可能であれば、trueを返します。
	 * <pre>
	 * @return true−移動可能 ／ false−移動不可能
	 */
	public boolean isMove(){

		// 移動ストップでない場合、
		if(!flgStopMove){
			// 移動可能。trueでリターン
			return true;
		}

		// 移動ストップ中
		// かつ 残機がある場合、
		if(remaining > 0){
			// 移動不可能。falseでリターン
			return false;

		// 残機がない場合、
		}else{
			// 移動可能。trueでリターン
			return true;
		}

	} // end isMove

	/**
	 * スプライト削除
	 * <pre>
	 * スプライトグループで管理しているスプライトを削除します。
	 * <pre>
	 * @return true − 削除後も他のスプライトは存在している ／ false − 存在していない
	 */
	public boolean removeSprite(){

		// 残機−１
		remaining--;

		// 残機が無くなった場合、
		if(remaining == 0){

			// ストーリーを再開する
			((KCtrlSKK)panel.getKCtrl()).getKStory().start();

			// スプライトグループを消す
			super.getKPanel().removeSpriteGroup(this);

			// falseでリターン
			return false;

		}

		// trueでリターン
		return true;

	} // end removeSprite

}
