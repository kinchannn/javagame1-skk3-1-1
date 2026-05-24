/**
 * ストーリークラス.
 * <pre>
 * 時間を管理し、タイミングが来たら、スプライトオブジェクトを生成します。
 * </pre>
 */
public class KStorySKK extends KStory {

	/**
	 * コンストラクタ.
	 * @param panel KPanel
	 */
	public KStorySKK(KPanel panel) throws Exception{

		// ファイル名を追加し、スーパークラスを呼び出す
		super(panel, "KStorySKK.txt");

	}

	/**
	 * ストーリー呼び出し.
	 * @param storyEvent イベント
	 * @param storyParam パラメータ
	 * @return スプライトオブジェクト
	 */
	public KSpriteObject storyEvent(String storyEvent, String storyParam){

		KSpriteObject spriteObject = null;

		// Ｓ
		if("S01".equals(storyEvent)){
			spriteObject = new KSpriteS01(super.getKPanel());

		// Ｍ
		}else if("S02".equals(storyEvent)){
			spriteObject = new KSpriteS02(super.getKPanel());

		// Ｈ
		}else if("S03".equals(storyEvent)){
			spriteObject = new KSpriteS03(super.getKPanel());

		// １
		}else if("S04".equals(storyEvent)){
			spriteObject = new KSpriteS04(super.getKPanel());

		// 敵０１ スターキラー改
		}else if("T01".equals(storyEvent)){
			spriteObject = new KSpriteGroupT01(super.getKPanel(), storyParam);

		// 敵０２ スターキラー改
		}else if("T02".equals(storyEvent)){
			spriteObject = new KSpriteGroupT02(super.getKPanel(), storyParam);

		// 敵０３ 岩
		}else if("T03".equals(storyEvent)){
			spriteObject = new KSpriteGroupT03(super.getKPanel(), storyParam);

		// 敵０４ メーウス改
		}else if("T04".equals(storyEvent)){
			spriteObject = new KSpriteGroupT04(super.getKPanel());

		// 敵０５ ガリ改
		}else if("T05".equals(storyEvent)){
			spriteObject = new KSpriteGroupT05(super.getKPanel(), storyParam);

		// 敵０６ フェラーキリ改
		}else if("T06".equals(storyEvent)){
			spriteObject = new KSpriteGroupT06(super.getKPanel(), storyParam);

		// 敵０７ ルーパー
		}else if("T07".equals(storyEvent)){
			spriteObject = new KSpriteGroupT07(super.getKPanel(), storyParam);

		// 敵０８ ピカ
		}else if("T08".equals(storyEvent)){
			spriteObject = new KSpriteGroupT08(super.getKPanel());

		// 敵０９ サイダー
		}else if("T09".equals(storyEvent)){
			spriteObject = new KSpriteGroupT09(super.getKPanel());

		// 敵１１ シンプルブラック
		}else if("T11".equals(storyEvent)){
			spriteObject = new KSpriteGroupT11(super.getKPanel(), storyParam);

		// 敵１２ 赤い岩
		}else if("T12".equals(storyEvent)){
			spriteObject = new KSpriteGroupT12(super.getKPanel(), storyParam);

		// 敵１３ 水晶
		}else if("T13".equals(storyEvent)){
			spriteObject = new KSpriteGroupT13(super.getKPanel(), storyParam);

		// 地面１ スターター
		}else if("J01".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ01(super.getKPanel());

		// 地面２ 基地
		}else if("J02".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ02(super.getKPanel(), storyParam);

		// 地面３ 高速
		}else if("J03".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ03(super.getKPanel(), storyParam);

		// 地面４ きん大陸１
		}else if("J04".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ04(super.getKPanel(), storyParam);

		// 地面５ きん大陸２
		}else if("J05".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ05(super.getKPanel(), storyParam);

		// 地面３１ あき２大陸
		}else if("J31".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ31(super.getKPanel(), storyParam);

		// 地面３２ あき２大陸
		}else if("J32".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ32(super.getKPanel(), storyParam);

		// 地面３３ あき２大陸
		}else if("J33".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ33(super.getKPanel(), storyParam);

		// 地面３４ あき２大陸
		}else if("J34".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ34(super.getKPanel(), storyParam);

		// 地面３５ あき２大陸
		}else if("J35".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ35(super.getKPanel(), storyParam);

		// 地面３６ あき２大陸
		}else if("J36".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ36(super.getKPanel(), storyParam);

		// 地面３７ あき２大陸
		}else if("J37".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ37(super.getKPanel(), storyParam);

		// 地面３８ あき２大陸
		}else if("J38".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ38(super.getKPanel(), storyParam);

		// 地面３９ あき２大陸
		}else if("J39".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ39(super.getKPanel(), storyParam);

		// 地面４０ あき２大陸
		}else if("J40".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ40(super.getKPanel(), storyParam);

		// 地面４１ あき２大陸
		}else if("J41".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ41(super.getKPanel(), storyParam);

		// 地面４２ あき２大陸
		}else if("J42".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ42(super.getKPanel(), storyParam);

		// 地面４３ あき２大陸
		}else if("J43".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ43(super.getKPanel(), storyParam);

		// 地面４４ あき２大陸
		}else if("J44".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ44(super.getKPanel(), storyParam);

		// 地面４５ あき２大陸
		}else if("J45".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ45(super.getKPanel(), storyParam);

		// 地面８０ 恒星 赤い星
		}else if("J80".equals(storyEvent)){
			spriteObject = new KSpriteJ80(super.getKPanel());

		// 地面８１ 恒星 青い星
		}else if("J81".equals(storyEvent)){
			spriteObject = new KSpriteJ81(super.getKPanel());

		// 敵３１
		}else if("T31".equals(storyEvent)){
			spriteObject = new KSpriteGroupT31(super.getKPanel());

		// 敵３２
		}else if("T32".equals(storyEvent)){
			spriteObject = new KSpriteGroupT32(super.getKPanel());

		// 敵３３
		}else if("T33".equals(storyEvent)){
			spriteObject = new KSpriteGroupT33(super.getKPanel());

		// 敵３４
		}else if("T34".equals(storyEvent)){
			spriteObject = new KSpriteGroupT34(super.getKPanel(), storyParam);

		// 敵４２
		}else if("T42".equals(storyEvent)){
			spriteObject = new KSpriteGroupT42(super.getKPanel());

		// ステージクリア
		}else if("C01".equals(storyEvent)){
			spriteObject = new KSpriteGroupC01(super.getKPanel());

		// オールクリア
		}else if("C02".equals(storyEvent)){
			spriteObject = new KSpriteGroupC02(super.getKPanel());

		}else{

		} // end if

		// リターン
		return spriteObject;

	} // end storyEvent

}
