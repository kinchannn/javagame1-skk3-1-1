/**
 * 敵３２
 */
public class KSpriteGroupT32 extends KSpriteGroup implements KConstant {

	/** 残機 */
	private static final int	REMAINING		= 5;

	/** 残機 */
	private			int			remaining		= REMAINING;

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 */
	public KSpriteGroupT32(KPanel panel){

		super(panel);

		// ストーリーを停止する
		((KCtrlSKK)panel.getKCtrl()).getKStory().stop();

		// ５機出現
		for(int i = 0; i < REMAINING; i++){

			// スプライトを生成
			KSpriteT32 kSpriteT32 = new KSpriteT32(super.getKPanel(), i, this);
			// スプライトを追加
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT32);

		}

	} // end KSpriteGroupT32

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

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
