/**
 * 敵３
 */
public class KSpriteGroupT03 extends KSpriteGroup implements KConstant {

	/** パラメータ（未使用） */
	private		String		storyParam	= null;

	/**
	 * コンストラクタ
	 * @param panel KPanel
	 * @param storyParam パラメータ。未使用。
	 */
	public KSpriteGroupT03(KPanel panel, String storyParam){
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
		if((time % 20) == 0){
			// スプライトを生成
			KSpriteT03 kSpriteT03 = new KSpriteT03(super.getKPanel());
			// スプライトを追加
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT03);
		}

		// 30回出たら、
		if(time == 580){
			// スプライトグループを消す
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}
