﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Этот код создан программой.
//     Исполняемая версия:4.0.30319.42000
//
//     Изменения в этом файле могут привести к неправильной работе и будут потеряны в случае
//     повторной генерации кода.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.ComponentModel;
using System.Diagnostics;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.Xml.Serialization;

// 
// Этот исходный код был создан с помощью wsdl, версия=4.8.3928.0.
// 


/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
[System.Web.Services.WebServiceBindingAttribute(Name="WebServiceSoap", Namespace="PVI_7b.Models")]
public partial class WebService : System.Web.Services.Protocols.SoapHttpClientProtocol {
    
    private System.Threading.SendOrPostCallback HelloWorldOperationCompleted;
    
    private System.Threading.SendOrPostCallback GetDictOperationCompleted;
    
    private System.Threading.SendOrPostCallback AddDictOperationCompleted;
    
    private System.Threading.SendOrPostCallback PutDictOperationCompleted;
    
    private System.Threading.SendOrPostCallback DeleteDictOperationCompleted;
    
    /// <remarks/>
    public WebService() {
        this.Url = "https://localhost:44353/WebService.asmx";
    }
    
    /// <remarks/>
    public event HelloWorldCompletedEventHandler HelloWorldCompleted;
    
    /// <remarks/>
    public event GetDictCompletedEventHandler GetDictCompleted;
    
    /// <remarks/>
    public event AddDictCompletedEventHandler AddDictCompleted;
    
    /// <remarks/>
    public event PutDictCompletedEventHandler PutDictCompleted;
    
    /// <remarks/>
    public event DeleteDictCompletedEventHandler DeleteDictCompleted;
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("PVI_7b.Models/HelloWorld", RequestNamespace="PVI_7b.Models", ResponseNamespace="PVI_7b.Models", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
    public string HelloWorld() {
        object[] results = this.Invoke("HelloWorld", new object[0]);
        return ((string)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginHelloWorld(System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("HelloWorld", new object[0], callback, asyncState);
    }
    
    /// <remarks/>
    public string EndHelloWorld(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((string)(results[0]));
    }
    
    /// <remarks/>
    public void HelloWorldAsync() {
        this.HelloWorldAsync(null);
    }
    
    /// <remarks/>
    public void HelloWorldAsync(object userState) {
        if ((this.HelloWorldOperationCompleted == null)) {
            this.HelloWorldOperationCompleted = new System.Threading.SendOrPostCallback(this.OnHelloWorldOperationCompleted);
        }
        this.InvokeAsync("HelloWorld", new object[0], this.HelloWorldOperationCompleted, userState);
    }
    
    private void OnHelloWorldOperationCompleted(object arg) {
        if ((this.HelloWorldCompleted != null)) {
            System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
            this.HelloWorldCompleted(this, new HelloWorldCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
        }
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("PVI_7b.Models/GetDict", RequestNamespace="PVI_7b.Models", ResponseNamespace="PVI_7b.Models", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
    public Contact[] GetDict() {
        object[] results = this.Invoke("GetDict", new object[0]);
        return ((Contact[])(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginGetDict(System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("GetDict", new object[0], callback, asyncState);
    }
    
    /// <remarks/>
    public Contact[] EndGetDict(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Contact[])(results[0]));
    }
    
    /// <remarks/>
    public void GetDictAsync() {
        this.GetDictAsync(null);
    }
    
    /// <remarks/>
    public void GetDictAsync(object userState) {
        if ((this.GetDictOperationCompleted == null)) {
            this.GetDictOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetDictOperationCompleted);
        }
        this.InvokeAsync("GetDict", new object[0], this.GetDictOperationCompleted, userState);
    }
    
    private void OnGetDictOperationCompleted(object arg) {
        if ((this.GetDictCompleted != null)) {
            System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
            this.GetDictCompleted(this, new GetDictCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
        }
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("PVI_7b.Models/AddDict", RequestNamespace="PVI_7b.Models", ResponseNamespace="PVI_7b.Models", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
    public Contact AddDict(Contact contact) {
        object[] results = this.Invoke("AddDict", new object[] {
                    contact});
        return ((Contact)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginAddDict(Contact contact, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("AddDict", new object[] {
                    contact}, callback, asyncState);
    }
    
    /// <remarks/>
    public Contact EndAddDict(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Contact)(results[0]));
    }
    
    /// <remarks/>
    public void AddDictAsync(Contact contact) {
        this.AddDictAsync(contact, null);
    }
    
    /// <remarks/>
    public void AddDictAsync(Contact contact, object userState) {
        if ((this.AddDictOperationCompleted == null)) {
            this.AddDictOperationCompleted = new System.Threading.SendOrPostCallback(this.OnAddDictOperationCompleted);
        }
        this.InvokeAsync("AddDict", new object[] {
                    contact}, this.AddDictOperationCompleted, userState);
    }
    
    private void OnAddDictOperationCompleted(object arg) {
        if ((this.AddDictCompleted != null)) {
            System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
            this.AddDictCompleted(this, new AddDictCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
        }
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("PVI_7b.Models/PutDict", RequestNamespace="PVI_7b.Models", ResponseNamespace="PVI_7b.Models", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
    public Contact PutDict(Contact contact) {
        object[] results = this.Invoke("PutDict", new object[] {
                    contact});
        return ((Contact)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginPutDict(Contact contact, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("PutDict", new object[] {
                    contact}, callback, asyncState);
    }
    
    /// <remarks/>
    public Contact EndPutDict(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Contact)(results[0]));
    }
    
    /// <remarks/>
    public void PutDictAsync(Contact contact) {
        this.PutDictAsync(contact, null);
    }
    
    /// <remarks/>
    public void PutDictAsync(Contact contact, object userState) {
        if ((this.PutDictOperationCompleted == null)) {
            this.PutDictOperationCompleted = new System.Threading.SendOrPostCallback(this.OnPutDictOperationCompleted);
        }
        this.InvokeAsync("PutDict", new object[] {
                    contact}, this.PutDictOperationCompleted, userState);
    }
    
    private void OnPutDictOperationCompleted(object arg) {
        if ((this.PutDictCompleted != null)) {
            System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
            this.PutDictCompleted(this, new PutDictCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
        }
    }
    
    /// <remarks/>
    [System.Web.Services.Protocols.SoapDocumentMethodAttribute("PVI_7b.Models/DeleteDict", RequestNamespace="PVI_7b.Models", ResponseNamespace="PVI_7b.Models", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
    public Contact DeleteDict(Contact contact) {
        object[] results = this.Invoke("DeleteDict", new object[] {
                    contact});
        return ((Contact)(results[0]));
    }
    
    /// <remarks/>
    public System.IAsyncResult BeginDeleteDict(Contact contact, System.AsyncCallback callback, object asyncState) {
        return this.BeginInvoke("DeleteDict", new object[] {
                    contact}, callback, asyncState);
    }
    
    /// <remarks/>
    public Contact EndDeleteDict(System.IAsyncResult asyncResult) {
        object[] results = this.EndInvoke(asyncResult);
        return ((Contact)(results[0]));
    }
    
    /// <remarks/>
    public void DeleteDictAsync(Contact contact) {
        this.DeleteDictAsync(contact, null);
    }
    
    /// <remarks/>
    public void DeleteDictAsync(Contact contact, object userState) {
        if ((this.DeleteDictOperationCompleted == null)) {
            this.DeleteDictOperationCompleted = new System.Threading.SendOrPostCallback(this.OnDeleteDictOperationCompleted);
        }
        this.InvokeAsync("DeleteDict", new object[] {
                    contact}, this.DeleteDictOperationCompleted, userState);
    }
    
    private void OnDeleteDictOperationCompleted(object arg) {
        if ((this.DeleteDictCompleted != null)) {
            System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
            this.DeleteDictCompleted(this, new DeleteDictCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
        }
    }
    
    /// <remarks/>
    public new void CancelAsync(object userState) {
        base.CancelAsync(userState);
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.SerializableAttribute()]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
[System.Xml.Serialization.XmlTypeAttribute(Namespace="PVI_7b.Models")]
public partial class Contact {
    
    private string idField;
    
    private string lastnameField;
    
    private string phoneNumberField;
    
    /// <remarks/>
    public string Id {
        get {
            return this.idField;
        }
        set {
            this.idField = value;
        }
    }
    
    /// <remarks/>
    public string Lastname {
        get {
            return this.lastnameField;
        }
        set {
            this.lastnameField = value;
        }
    }
    
    /// <remarks/>
    public string PhoneNumber {
        get {
            return this.phoneNumberField;
        }
        set {
            this.phoneNumberField = value;
        }
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
public delegate void HelloWorldCompletedEventHandler(object sender, HelloWorldCompletedEventArgs e);

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
public partial class HelloWorldCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
    
    private object[] results;
    
    internal HelloWorldCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
            base(exception, cancelled, userState) {
        this.results = results;
    }
    
    /// <remarks/>
    public string Result {
        get {
            this.RaiseExceptionIfNecessary();
            return ((string)(this.results[0]));
        }
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
public delegate void GetDictCompletedEventHandler(object sender, GetDictCompletedEventArgs e);

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
public partial class GetDictCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
    
    private object[] results;
    
    internal GetDictCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
            base(exception, cancelled, userState) {
        this.results = results;
    }
    
    /// <remarks/>
    public Contact[] Result {
        get {
            this.RaiseExceptionIfNecessary();
            return ((Contact[])(this.results[0]));
        }
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
public delegate void AddDictCompletedEventHandler(object sender, AddDictCompletedEventArgs e);

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
public partial class AddDictCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
    
    private object[] results;
    
    internal AddDictCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
            base(exception, cancelled, userState) {
        this.results = results;
    }
    
    /// <remarks/>
    public Contact Result {
        get {
            this.RaiseExceptionIfNecessary();
            return ((Contact)(this.results[0]));
        }
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
public delegate void PutDictCompletedEventHandler(object sender, PutDictCompletedEventArgs e);

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
public partial class PutDictCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
    
    private object[] results;
    
    internal PutDictCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
            base(exception, cancelled, userState) {
        this.results = results;
    }
    
    /// <remarks/>
    public Contact Result {
        get {
            this.RaiseExceptionIfNecessary();
            return ((Contact)(this.results[0]));
        }
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
public delegate void DeleteDictCompletedEventHandler(object sender, DeleteDictCompletedEventArgs e);

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("wsdl", "4.8.3928.0")]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
public partial class DeleteDictCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
    
    private object[] results;
    
    internal DeleteDictCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
            base(exception, cancelled, userState) {
        this.results = results;
    }
    
    /// <remarks/>
    public Contact Result {
        get {
            this.RaiseExceptionIfNecessary();
            return ((Contact)(this.results[0]));
        }
    }
}
