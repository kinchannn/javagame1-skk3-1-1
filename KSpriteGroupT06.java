/**
 * 敵６
 */
public class KSpriteGroupT06 extends KSpriteGroup implements KConstant {

	/** ビーム発射フラグ */
	private		String		storyParam	= null;

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param storyParam ビーム発射フラグ
	 */
	public KSpriteGroupT06(KPanel panel, String storyParam){
		super(panel);
		this.storyParam = storyParam;
	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * <pre>
	 */
	public void run(){

		// 一定時間経過の場合、
		if((time % 30) == 0){
			// スプライトを生成
			KSpriteT06 kSpriteT06 = new KSpriteT06(super.getKPanel(), storyParam);
			// スプライトを追加
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT06);
		}

		// 10回出たら、
		if(time == 300){
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}
