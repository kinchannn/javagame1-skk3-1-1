/**
 * 地面スプライト 破壊可能
 * <pre>
 * 地面スプライトオブジェクトとして共通化できる部分を記述します。
 * 型を判定するために、当クラスを作成しています。
 * <pre>
 */
public class KSpriteG00 extends KSpriteJ00 implements KConstant {

	/**
	 * コンストラクタ
	 * <pre>
	 * スプライトとスプライトグループの連携が必要ない場合は、当コンストラクタを使用ください。
	 * </pre>
	 * @param panel パネル
	 */
	public KSpriteG00(KPanel panel){

		super(panel);

	}

	/**
	 * コンストラクタ
	 * <pre>
	 * スプライトとスプライトグループの連携が必要な場合は、当コンストラクタを使用ください。
	 * </pre>
	 * @param panel パネル
	 * @param spriteGroup スプライトグループ
	 */
	public KSpriteG00(KPanel panel, KSpriteGroupJ00 spriteGroup){

		super(panel, spriteGroup);

	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		// スーパークラスを呼び出す
		super.run();

	} // end run

	/**
	 * スプライト削除
	 * <pre>
	 * スプライトグループが存在する場合、スプライトが削除されたことを通知します。
	 * <pre>
	 */
	public void removeSprite(){

		// スーパークラスを呼び出す
		super.removeSprite();

	} // end removeSprite

}
