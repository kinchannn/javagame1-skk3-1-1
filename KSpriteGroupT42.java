/**
 * 敵４２
 */
public class KSpriteGroupT42 extends KSpriteGroup implements KConstant {

	/** 残機 */
	private static final int	REMAINING		= 8;

	/** 残機 */
	private			int			remaining		= REMAINING * 8;

	/** 時間 */
	private			int			time			= -1;

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 */
	public KSpriteGroupT42(KPanel panel){

		super(panel);

		// ストーリーを停止する
		((KCtrlSKK)panel.getKCtrl()).getKStory().stop();

	} // end KSpriteGroupT42

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

		// 時間＋１
		time++;

		// 時間がきたら
		if(time == 0 || time == 30 || time == 60 || time == 90 ||
						time == 120 || time == 150 || time == 180 || time == 210){

			// 8機出現
			for(int i = 0; i < REMAINING; i++){

				// スプライトを生成
				KSpriteT42 kSpriteT42 = new KSpriteT42(super.getKPanel(), i, this);
				// スプライトを追加
				super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT42);

			}

		}

	} // end run

	/**
	 * スプライト削除
	 * <pre>
	 * スプライトグループで管理しているスプライトを削除します。
	 * <pre>
	 */
	public void removeSprite(){

		// 残機−１
		remaining--;

		// 残機が無くなった場合、
		if(remaining == 0){

			// ストーリーを再開する
			((KCtrlSKK)panel.getKCtrl()).getKStory().start();

			// スプライトグループを消す
			super.getKPanel().removeSpriteGroup(this);

		}

	} // end removeSprite

}
