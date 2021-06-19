package id.xxx.xposed

import android.app.Activity
import android.os.Bundle
import android.util.Log
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage
import java.io.ByteArrayInputStream
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate

class MainXposedHookLoadPackage : IXposedHookLoadPackage {

    private fun hookActivityOnCreate(block: (Activity) -> Unit): XC_MethodHook.Unhook {
        return XposedHelpers.findAndHookMethod(
            Activity::class.java,
            "onCreate",
            Bundle::class.java,
            object : XC_MethodHook() {
                override fun beforeHookedMethod(param: MethodHookParam) {
                    block((param.thisObject as Activity))
                }
            })
    }


    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {

        hookActivityOnCreate {
            val packageName = "com.app.nic22.banglarbhumi"
            val context = it.baseContext
            val signatures = context.packageManager.getPackageInfo(packageName, 64).signatures;
            signatures.forEach { signature ->
                val x509Certificate = CertificateFactory.getInstance("X.509")
                    .generateCertificate(ByteArrayInputStream(signature.toByteArray())) as X509Certificate
                XposedBridge.log("SIG ALGO ID: ${x509Certificate.sigAlgOID}")
                Log.i("SIG ALGO ID: ", x509Certificate.sigAlgOID)

            }
        }
    }
}
