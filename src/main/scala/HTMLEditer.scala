//2-6上級問題 JavaFXの公式サイトを参考に、scalaでHTMLエディターを作成する

//わからなかったので、解答を参照(プルリクは出しません)

//必要なライブラリをインポート
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

/* 
//JavaFXの公式ドキュメントより、HTMLエディタの実装コード
//https://docs.oracle.com/javase/jp/8/javafx/user-interface-tutorial/editor.htm#CHDBEGDD
//これをscalaに書き換えるのが今回の解答になる？
    public class HTMLEditorSample extends Application {

        @Override
        public void start(Stage stage) {
            stage.setTitle("HTMLEditor Sample");
            stage.setWidth(650);
            stage.setHeight(300);   
            final HTMLEditor htmlEditor = new HTMLEditor();
            htmlEditor.setPrefHeight(245);
            Scene scene = new Scene(htmlEditor);       
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    } 
*/

//実行時、最初に呼び出される関数
object Main extends App {
    //JavaFXの起動
    //classOf[Main] で、この下で定義しているMainクラスを渡している
    Application.launch(classOf[Main], args: _*)
}


//エディターの定義
class Main extends Application {
    override def start(primaryStage: Stage): Unit = {
        /* 
            Stageクラス...JavaFXの最上位のコンテナで、Sceneをウィンドウに表示する
            Sceneクラス...様々なシーングラフのルートノードを乗せたコンテナ(Stageコンテナの直下コンテナ)
        */
        primaryStage.setTitle("エディター");  //本JavaFXパネルに表示されるタイトル
        primaryStage.setWidth(650);  //本JavaFXパネルの横幅を設定
        primaryStage.setHeight(300);  //本JavaFXパネルの縦幅を設定
        val htmlEditor = new HTMLEditor();  //HTMLEditorクラスのオブジェクトを作成
        htmlEditor.setPrefHeight(245);  //コンテンツ(ここではHTMLEditorクラスのオブジェクト)の縦幅設定
        val scene = new Scene(htmlEditor);  //HTMLエディターを持つ、Sceneオブジェクトを作成する
        primaryStage.setScene(scene);  //作成したSceneのオブジェクトを、Stageに設置
        primaryStage.show();  //Stageを表示
    }
}
