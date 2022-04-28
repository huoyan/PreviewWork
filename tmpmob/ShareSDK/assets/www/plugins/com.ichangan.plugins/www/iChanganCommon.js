cordova.define(
  "com.ichangan.plugins.iChanganCommon",
  function (require, exports, module) {
    var exec = require("cordova/exec");

    module.exports = {
      //初始化sdk
      initSDK: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "initSDK", [param]);
      },
      //获取车况状态数据
      getCarData: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "getCarData", [param]);
      },
      //获取车辆位置信息
      getRemoteCarLocation: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "getRemoteCarLocation", [
          param,
        ]);
      },
      //发送控车指令
      controlCar: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "controlCar", [param]);
      },
      //获取短信验证码
      sendShortMessage: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "sendShortMessage", [
          param,
        ]);
      },
      //发送控车指令
      verifyShortMessage: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "verifyShortMessage", [
          param,
        ]);
      },
      download: function (url, success, error) {
        exec(success, error, "iChanganCommonLocal", "download", [url]);
      },
      setBaseUrl: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "setBaseUrl", [
          param.baseUrl,
          param.isNev,
        ]);
      },

      getMessageTypeTrunks: function (token, success, fail) {
        exec(success, fail, "iChanganCommonLocal", "getMessageTypeTrunks", [
          token,
        ]);
      },

      getLatestMessage: function (
        token,
        userId,
        needRefresh,
        carId,
        success,
        fail
      ) {
        exec(success, fail, "iChanganCommonLocal", "getLatestMessage", [
          token,
          userId,
          needRefresh,
          carId,
        ]);
      },

      requestDataFromCache: function (
        token,
        userId,
        messageType,
        pageIndex,
        pageNum,
        success,
        fail
      ) {
        exec(success, fail, "iChanganCommonLocal", "requestDataFromCache", [
          token,
          userId,
          messageType,
          pageIndex,
          pageNum,
        ]);
      },

      refreshCacheData: function (token, userId, messageType, success, fail) {
        exec(success, fail, "iChanganCommonLocal", "refreshCacheData", [
          token,
          userId,
          messageType,
        ]);
      },

      markAsRead: function (id, success, fail) {
        exec(success, fail, "iChanganCommonLocal", "markAsRead", [id]);
      },

      deleteMessage: function (id, success, fail) {
        exec(success, fail, "iChanganCommonLocal", "deleteMessage", [id]);
      },

      getUnReadMessage: function (userId, success, fail) {
        exec(success, fail, "iChanganCommonLocal", "getUnReadMessage", [
          userId,
        ]);
      },

      // message center login
      userLogin: function (token, userId, carId, success, fail) {
        exec(success, fail, "iChanganCommonLocal", "userLogin", [
          token,
          userId,
          carId,
        ]);
      },

      logout: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "logout", [
          param.token,
          param.userId,
        ]);
      },

      sendUserInfo: function (token, userId, carId, success, error) {
        exec(success, error, "iChanganCommonLocal", "sendUserInfo", [
          token,
          userId,
          carId,
        ]);
      },

      isNetworkAvailable: function (success) {
        exec(
          success,
          function () {},
          "iChanganCommonLocal",
          "isNetworkAvailable",
          []
        );
      },

      isWifi: function (success, error) {
        exec(success, error, "iChanganCommonLocal", "isWifi", []);
      },

      refreshToken: function (data, success, error) {
        exec(success, error, "refreshToken", "refreshToken", [data]);
      },

      // getDeviceInfo: function (success) {
      //   exec(success, function () {}, "iChanganCommon", "getDeviceInfo", []);
      // },

      getDeviceInfo: function (success) {
        exec(
          success,
          function () {},
          "iChanganCommonLocal",
          "getDeviceInfo",
          []
        );
      },

      useFingerprint: function (message, success, error) {
        exec(success, error, "iChanganCommonLocal", "useFingerprint", [
          message,
        ]);
      },

      openAddressSelector: function (params, success, error) {
        exec(success, error, "iChanganCommonLocal", "openAddressSelector", [
          params,
        ]);
      },

      openFenceDetail: function (params, success, error) {
        exec(success, error, "iChanganCommonLocal", "openFenceDetail", [
          params,
        ]);
      },

      openPoiDetail: function (params, success, error) {
        exec(success, error, "iChanganCommonLocal", "openPoiDetail", [params]);
      },

      openMapMessageDetail: function (params, success, error) {
        exec(success, error, "iChanganCommonLocal", "openMapMessageDetail", [params,
        ]);
      },

      openSurService: function (carData, success, error) {
        exec(success, error, "iChanganCommonLocal", "openSurService", [
          carData,
        ]);
      },

      fileList: function (success, error) {
        exec(success, error, "iChanganCommonLocal", "fileList", []);
      },

      openPdf: function (data, success, error) {
        exec(success, error, "iChanganCommonLocal", "openPdf", [data]);
      },

      changePDFName: function (data, success, error) {
        exec(success, error, "iChanganCommonLocal", "changePDFName", [data]);
      },
      //跳转微信&QQ登录
      goWxLogin: function (data, success, error) {
        debugger
        exec(success, error, "iChanganCommonLocal", "goWxLogin", [data]);
      },
      //请求短信验证码
      goWxSms: function (data, success, error) {
        exec(success, error, "iChanganCommonLocal", "goWxSms", [data]);
      },
      //与微信绑定
      goWxBind: function (data, success, error) {
        exec(success, error, "iChanganCommonLocal", "goWxBind", [data]);
      },

      share: function (shareObject, success, error) {
        exec(success, error, "iChanganCommonLocal", "share", [
          shareObject.destId,
          shareObject.myId,
        ]);
      },

      decryptContent: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "decryptContent", [param]);
      },

      encryptPinCode: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "encryptPinCode", [param]);
      },

      getVersion: function (success, error) {
        exec(success, error, "iChanganCommonLocal", "getVersion", []);
      },

      updateCarLocation: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "updateCarLocation", [
          param,
        ]);
      },

      scanBarCode: function (title, success, error) {
        exec(success, error, "iChanganCommonLocal", "scanBarCode", [title]);
      },

      idRecognition: function (data, success, error) {
        exec(success, error, "iChanganCommonLocal", "idRecognition", [data]);
      },

      getAppInfo: function (success, fail) {
        exec(success, fail, "iChanganCommonLocal", "getAppInfo", []);
      },

      getFilePath: function (success, fail) {
        exec(success, fail, "iChanganCommonLocal", "getFilePath", []);
      },

      getXGToken: function (success, fail) {
        exec(success, fail, "iChanganCommonLocal", "getXGToken", []);
      },

      // iOS only
      getCarResourceInfo: function (path, success, fail) {
        exec(success, fail, "iChanganCommonLocal", "getCarResourceInfo", [
          path,
        ]);
      },

      // sercretLogin
      login: function (param, success, fail) {
        exec(success, fail, "iChanganCommonLocal", "login", [param]);
      },

      shareWeChatMoments: function (text, imgpath, url, success, error) {
        exec(success, error, "iChanganCommonLocal", "shareWeChatMoments", [
          text,
          imgpath,
          url,
        ]);
      },

      //打开高德地图
      startGaode: function (param, success, fail) {
        exec(success, fail, "iChanganCommonLocal", "startGaode", [param]);
      },
      //打开百度地图
      startBaidu: function (param, success, fail) {
        exec(success, fail, "iChanganCommonLocal", "startBaidu", [param]);
      },
      startNewWebActivity: function (text, imgpath, url, success, error) {
        exec(success, error, "iChanganCommonLocal", "startNewWebActivity", [
          text,
          imgpath,
          url,
        ]);
      },
      // 获取手机权限
      checkPermission: function (success, fail) {
        exec(success, fail, "iChanganCommonLocal", "checkPermission", []);
      },
      // rsa加密
      getKey: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "getKey", [param]);
      },
      // 蓝牙钥匙启动
      goToBlueKey: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "goToBlueKey", [param]);
      },
      // 近程泊车
      go2NearMovCar: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "go2NearMovCar", [param]);
      },
      // 远程泊车
      go2MovCar: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "go2MovCar", [param]);
      },
      // 远程监控
      go2Monitor: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "go2Monitor", [param]);
      },
      // 获取蓝牙认证信息
      getBlueKeyInfo: function (param, success, error) {
        exec(success, error, "BlueKeyPlugin", "getOwnerKeys", [param.carId]);
      },
      // 初始化捷德蓝牙sdk
      initGDSdk: function (param, success, error) {
        exec(success, error, "iChanganCommonLocal", "initGDSdk", [param]);
      },
      // 查询sdk初始化状态
      getGDSdkStatus: function (param, success, error) {
        exec(success, error, "BlueKeyPlugin", "getGDSdkStatus", [
          param.userId,
          param.token,
          param.carId,
        ]);
      },
      getBluetoothState: function (success, error) {
        exec(success, error, "BlueKeyPlugin", "getBluetoothState", []);
      },
      go2EnterAc: function (params, success, error) {
        exec(success, error, "iChanganCommonLocal", "go2EnterAc", [params]);
      },
      getCurrentLocation: function (params, success, error) {
        exec(success, error, "iChanganCommonLocal", "getCurrentLocation", [params]);
      },
      /**连接蓝牙（瓶钵）*/
      startBle: function (params, success, error) {
        exec(success, error, "iChanganCommonLocal", "startBle", [params]);
      },
      /**打开蓝牙v2（瓶钵）*/
      openBluetooth: function (params, success, error) {
        exec(success, error, "iChanganCommonLocal", "openBluetooth", [params]);
      },
      /**获取蓝牙状态v2（瓶钵）*/
      getBluetoothStateV2: function (params, success, error) {
        exec(success, error, "iChanganCommonLocal", "getBluetoothState", [params]);
      },
      /**获取蓝牙钥匙列表v2（瓶钵）*/
      getVehicleKeyList: function (params, success, error) {
        exec(success, error, "iChanganCommonLocal", "getVehicleKeyList", [params]);
      },
      /**数字钥匙登陆（瓶钵）*/
      digitalKeyLogin: function (params, success, error) {
        exec(success, error, "iChanganCommonLocal", "digitalKeyLogin", [params]);
      },
      /**退出时告知安卓v2（瓶钵）*/
      logoutAndroid: function (params, success, error) {
        exec(success, error, "iChanganCommonLocal", "logoutAndroid", [params]);
      },
      /**初始化SDKv2（瓶钵）*/
      initDigitalKaySDK: function (params,success, error) {
       exec(success, error, "iChanganCommonLocal", "initDigitalKaySDK", [params]);
      },
      /**初始化SDK蓝牙状态获取（饶工）*/
      initVkSdk: function (params,success, error) {
        exec(success, error, "iChanganCommonLocal", "initVkSdk", [params]);
      },
      /**分享数字钥匙请求（瓶钵）*/
      shareDK: function (params,success, error) {
        exec(success, error, "iChanganCommonLocal", "shareDK", [params]);
      },
      /**回收数字钥匙请求（瓶钵）*/
      revokeDK: function (params,success, error) {
        exec(success, error, "iChanganCommonLocal", "revokeDK", [params]);
      },
      /**更新可信任的根证书列表v2（瓶钵）*/
      updateTrustedCertList: function (params,success, error) {
        exec(success, error, "iChanganCommonLocal", "updateTrustedCertList", [params]);
      },
      /**设置认证类型v2（瓶钵）*/
      setAuthenticator: function (params,success, error) {
        exec(success, error, "iChanganCommonLocal", "setAuthenticator", [params]);
      },
      /**更新数字钥匙列表v2（瓶钵）*/
      updateDkList: function (params,success, error) {
        exec(success, error, "iChanganCommonLocal", "updateDkList", [params]);
      },
      /**获取所有钥匙（瓶钵）*/
      getVehicleList: function (params,success, error) {
        exec(success, error, "iChanganCommonLocal", "getVehicleList", [params]);
      },
      /**控车指令（瓶钵）*/
      operateCar: function (params,success, error) {
        exec(success, error, "iChanganCommonLocal", "operateCar", [params]);
      },
      /**连接车辆（瓶钵）*/
      connectCar: function (params,success, error) {
        exec(success, error, "iChanganCommonLocal", "connectCar", [params]);
      },
      /**⼿动触发拉取指令列表（瓶钵）*/
      updateInstructionList: function (params,success, error) {
        exec(success, error, "iChanganCommonLocal", "updateInstructionList", [params]);
      },
      /*
       * Step for add plugin method
       * ***
       * 1. Add method here, notice the ',' at end of function
       * 2. Find {YOUR_PROJECT}/plugins/ios.json(android.json)
       * 3. Remove "com.ichangan.plugins": {...}
       * 4. Run commond: cordova plugin add ./plugins_custom
       * 5. Add native method in .java file or .msetAuthenticator/.swift file
       * ***
       */
    };
  }
);
