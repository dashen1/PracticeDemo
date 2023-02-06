package com.example.myapplication.reflection;

public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        ClassLoader classLoader = Class.forName("com.example.myapplication.reflection.Test07").getClassLoader();
        System.out.println(classLoader);

        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        System.out.println(System.getProperty("java.class.path"));
        /**
         *D:\Android\sdk\platforms\android-31\android.jar;
         * D:\Android\sdk\platforms\android-31\data\res;
         * E:\android\Java\javaAdvancedFeatures\myapplication\app\build\intermediates\javac\debug\classes;
         * E:\android\Java\javaAdvancedFeatures\myapplication\app\build\intermediates\compile_and_runtime_not_namespaced_r_class_jar\debug\R.jar;
         * E:\android\Java\javaAdvancedFeatures\myapplication\app\build\generated\res\resValues\debug;
         * C:\Users\se0891\.gradle\caches\modules-2\files-2.1\androidx.collection\collection\1.1.0\1f27220b47669781457de0d600849a5de0e89909\collection-1.1.0.jar;C:\Users\se0891\.gradle\caches\modules-2\files-2.1\androidx.lifecycle\lifecycle-common\2.4.0\1fdb7349701e9cf2f0a69fc10642b6fef6bb3e12\lifecycle-common-2.4.0.jar;
         * C:\Users\se0891\.gradle\caches\modules-2\files-2.1\androidx.arch.core\core-common\2.1.0\b3152fc64428c9354344bd89848ecddc09b6f07e\core-common-2.1.0.jar;C:\Users\se0891\.gradle\caches\modules-2\files-2.1\androidx.annotation\annotation\1.3.0\21f49f5f9b85fc49de712539f79123119740595\annotation-1.3.0.jar;
         * C:\Users\se0891\.gradle\caches\transforms-3\ddb35e8ab2da234b6ae23a68bcb28fbe\transformed\material-1.4.0\jars\classes.jar;
         * C:\Users\se0891\.gradle\caches\transforms-3\ddb35e8ab2da234b6ae23a68bcb28fbe\transformed\material-1.4.0\res;
         * C:\Users\se0891\.gradle\caches\transforms-3\ddb35e8ab2da234b6ae23a68bcb28fbe\transformed\material-1.4.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\bb3a90f417ba06fed170bce856413bc3\transformed\appcompat-1.4.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\bb3a90f417ba06fed170bce856413bc3\transformed\appcompat-1.4.0\res;C:\Users\se0891\.gradle\caches\transforms-3\bb3a90f417ba06fed170bce856413bc3\transformed\appcompat-1.4.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\06a38bd66cf60f859c0f7b02d8d40279\transformed\jetified-viewpager2-1.0.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\06a38bd66cf60f859c0f7b02d8d40279\transformed\jetified-viewpager2-1.0.0\res;C:\Users\se0891\.gradle\caches\transforms-3\06a38bd66cf60f859c0f7b02d8d40279\transformed\jetified-viewpager2-1.0.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\2875e30beb429efd89d07fc4fa7a4dc5\transformed\fragment-1.3.6\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\2875e30beb429efd89d07fc4fa7a4dc5\transformed\fragment-1.3.6\res;C:\Users\se0891\.gradle\caches\transforms-3\2875e30beb429efd89d07fc4fa7a4dc5\transformed\fragment-1.3.6\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\12943f985bf5f9400a2cead3dfc0495e\transformed\jetified-activity-1.2.4\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\12943f985bf5f9400a2cead3dfc0495e\transformed\jetified-activity-1.2.4\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\744af3eba3642194a8d9fb30fb9af41d\transformed\jetified-appcompat-resources-1.4.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\744af3eba3642194a8d9fb30fb9af41d\transformed\jetified-appcompat-resources-1.4.0\res;C:\Users\se0891\.gradle\caches\transforms-3\744af3eba3642194a8d9fb30fb9af41d\transformed\jetified-appcompat-resources-1.4.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\b12ab52471e52a5d335ab40fd772c720\transformed\drawerlayout-1.0.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\b12ab52471e52a5d335ab40fd772c720\transformed\drawerlayout-1.0.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\f849573ebabedb42c1e877a5ffa2dc27\transformed\coordinatorlayout-1.1.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\f849573ebabedb42c1e877a5ffa2dc27\transformed\coordinatorlayout-1.1.0\res;C:\Users\se0891\.gradle\caches\transforms-3\f849573ebabedb42c1e877a5ffa2dc27\transformed\coordinatorlayout-1.1.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\a0054b4fd9558d4b435d9f562d6d5899\transformed\dynamicanimation-1.0.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\a0054b4fd9558d4b435d9f562d6d5899\transformed\dynamicanimation-1.0.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\733de9cf87aba363c2e0952ded751ba4\transformed\recyclerview-1.1.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\733de9cf87aba363c2e0952ded751ba4\transformed\recyclerview-1.1.0\res;C:\Users\se0891\.gradle\caches\transforms-3\733de9cf87aba363c2e0952ded751ba4\transformed\recyclerview-1.1.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\7dff21789f0c8ef66de171ceeee3d754\transformed\transition-1.2.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\7dff21789f0c8ef66de171ceeee3d754\transformed\transition-1.2.0\res;C:\Users\se0891\.gradle\caches\transforms-3\7dff21789f0c8ef66de171ceeee3d754\transformed\transition-1.2.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\b6e57b965a800a0b2e5802f8b176c566\transformed\vectordrawable-animated-1.1.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\b6e57b965a800a0b2e5802f8b176c566\transformed\vectordrawable-animated-1.1.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\f2301761585be6897283cf49f49774f5\transformed\vectordrawable-1.1.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\f2301761585be6897283cf49f49774f5\transformed\vectordrawable-1.1.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\cdab1698f98955d8f3198b0cba248315\transformed\viewpager-1.0.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\cdab1698f98955d8f3198b0cba248315\transformed\viewpager-1.0.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\7bdfe158866403413dfb83c6486a6afc\transformed\legacy-support-core-utils-1.0.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\7bdfe158866403413dfb83c6486a6afc\transformed\legacy-support-core-utils-1.0.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\862113e6c11b47fe0c0c60423a26c701\transformed\loader-1.0.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\862113e6c11b47fe0c0c60423a26c701\transformed\loader-1.0.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\a613904c1c087ac0b6b335b2374b29f0\transformed\customview-1.0.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\a613904c1c087ac0b6b335b2374b29f0\transformed\customview-1.0.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\ed15369935d830f0be0a1622e8b0fd14\transformed\core-1.7.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\ed15369935d830f0be0a1622e8b0fd14\transformed\core-1.7.0\res;C:\Users\se0891\.gradle\caches\transforms-3\ed15369935d830f0be0a1622e8b0fd14\transformed\core-1.7.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\86340fccc259b3a6fb6ae0f2f13af9d8\transformed\cursoradapter-1.0.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\86340fccc259b3a6fb6ae0f2f13af9d8\transformed\cursoradapter-1.0.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\02338e06418f130f082b9064f14d6a6f\transformed\jetified-lifecycle-viewmodel-savedstate-2.3.1\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\02338e06418f130f082b9064f14d6a6f\transformed\jetified-lifecycle-viewmodel-savedstate-2.3.1\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\2317f67c27167987f3fcd69bcb3b898c\transformed\jetified-savedstate-1.1.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\2317f67c27167987f3fcd69bcb3b898c\transformed\jetified-savedstate-1.1.0\res;C:\Users\se0891\.gradle\caches\transforms-3\2317f67c27167987f3fcd69bcb3b898c\transformed\jetified-savedstate-1.1.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\3bc303636ed710ca62b2cb8183917bb3\transformed\cardview-1.0.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\3bc303636ed710ca62b2cb8183917bb3\transformed\cardview-1.0.0\res;C:\Users\se0891\.gradle\caches\transforms-3\3bc303636ed710ca62b2cb8183917bb3\transformed\cardview-1.0.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\d0164f36aa3b2ea25c70cbefe65252ea\transformed\lifecycle-runtime-2.4.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\d0164f36aa3b2ea25c70cbefe65252ea\transformed\lifecycle-runtime-2.4.0\res;C:\Users\se0891\.gradle\caches\transforms-3\d0164f36aa3b2ea25c70cbefe65252ea\transformed\lifecycle-runtime-2.4.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\da854ac2520be0f962ff76847f719125\transformed\versionedparcelable-1.1.1\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\da854ac2520be0f962ff76847f719125\transformed\versionedparcelable-1.1.1\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\daa4c8012c628d1912f219bea498f2bd\transformed\lifecycle-viewmodel-2.3.1\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\daa4c8012c628d1912f219bea498f2bd\transformed\lifecycle-viewmodel-2.3.1\res;C:\Users\se0891\.gradle\caches\transforms-3\daa4c8012c628d1912f219bea498f2bd\transformed\lifecycle-viewmodel-2.3.1\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\da738de40c9e55db84cd2a2a24c64074\transformed\lifecycle-livedata-2.0.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\da738de40c9e55db84cd2a2a24c64074\transformed\lifecycle-livedata-2.0.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\801f365c41fd42f3ad8e92351ee2ba2e\transformed\lifecycle-livedata-core-2.3.1\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\801f365c41fd42f3ad8e92351ee2ba2e\transformed\lifecycle-livedata-core-2.3.1\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\56dd221ce039a0c5b072fd8e8ba729b7\transformed\core-runtime-2.1.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\56dd221ce039a0c5b072fd8e8ba729b7\transformed\core-runtime-2.1.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\99629d6170df3842332395cfd18e63dd\transformed\interpolator-1.0.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\99629d6170df3842332395cfd18e63dd\transformed\interpolator-1.0.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\31de81494ea9d0b5eca8cec9201269f2\transformed\documentfile-1.0.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\31de81494ea9d0b5eca8cec9201269f2\transformed\documentfile-1.0.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\8348abe9af1e29eeeb15f5e64c7ebd15\transformed\localbroadcastmanager-1.0.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\8348abe9af1e29eeeb15f5e64c7ebd15\transformed\localbroadcastmanager-1.0.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\fd31312050a5694d589d84a1e263d9fa\transformed\print-1.0.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\fd31312050a5694d589d84a1e263d9fa\transformed\print-1.0.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\a8f2f19b6c5aef296d6471270fc168cc\transformed\jetified-annotation-experimental-1.1.0\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\a8f2f19b6c5aef296d6471270fc168cc\transformed\jetified-annotation-experimental-1.1.0\res;C:\Users\se0891\.gradle\caches\transforms-3\a8f2f19b6c5aef296d6471270fc168cc\transformed\jetified-annotation-experimental-1.1.0\AndroidManifest.xml;C:\Users\se0891\.gradle\caches\transforms-3\13cca231fe030f79afabc6b703680b10\transformed\constraintlayout-2.1.2\jars\classes.jar;C:\Users\se0891\.gradle\caches\transforms-3\13cca231fe030f79afabc6b703680b10\transformed\constraintlayout-2.1.2\res;C:\Users\se0891\.gradle\caches\transforms-3\13cca231fe030f79afabc6b703680b10\transformed\constraintlayout-2.1.2\AndroidManifest.xml
         */
    }
}