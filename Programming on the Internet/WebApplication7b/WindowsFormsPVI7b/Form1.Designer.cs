namespace WindowsFormsPVI7b
{
    partial class Form1
    {
        /// <summary>
        /// Обязательная переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Требуемый метод для поддержки конструктора — не изменяйте 
        /// содержимое этого метода с помощью редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            this.RefreshButton = new System.Windows.Forms.Button();
            this.DeleteButton = new System.Windows.Forms.Button();
            this.DeleteId = new System.Windows.Forms.TextBox();
            this.UpdateId = new System.Windows.Forms.TextBox();
            this.UpdateLastname = new System.Windows.Forms.TextBox();
            this.UpdatePhoneNumber = new System.Windows.Forms.TextBox();
            this.UpdateButton = new System.Windows.Forms.Button();
            this.SaveButton = new System.Windows.Forms.Button();
            this.ContactsList = new System.Windows.Forms.DataGridView();
            ((System.ComponentModel.ISupportInitialize)(this.ContactsList)).BeginInit();
            this.SuspendLayout();
            // 
            // RefreshButton
            // 
            this.RefreshButton.Location = new System.Drawing.Point(514, 10);
            this.RefreshButton.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.RefreshButton.Name = "RefreshButton";
            this.RefreshButton.Size = new System.Drawing.Size(76, 100);
            this.RefreshButton.TabIndex = 0;
            this.RefreshButton.Text = "Refresh List";
            this.RefreshButton.UseVisualStyleBackColor = true;
            this.RefreshButton.Click += new System.EventHandler(this.RefreshButton_Click);
            // 
            // DeleteButton
            // 
            this.DeleteButton.Location = new System.Drawing.Point(514, 337);
            this.DeleteButton.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.DeleteButton.Name = "DeleteButton";
            this.DeleteButton.Size = new System.Drawing.Size(76, 19);
            this.DeleteButton.TabIndex = 2;
            this.DeleteButton.Text = "Delete";
            this.DeleteButton.UseVisualStyleBackColor = true;
            this.DeleteButton.Click += new System.EventHandler(this.DeleteButton_Click);
            // 
            // DeleteId
            // 
            this.DeleteId.Location = new System.Drawing.Point(9, 338);
            this.DeleteId.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.DeleteId.Name = "DeleteId";
            this.DeleteId.Size = new System.Drawing.Size(502, 20);
            this.DeleteId.TabIndex = 3;
            // 
            // UpdateId
            // 
            this.UpdateId.Location = new System.Drawing.Point(9, 250);
            this.UpdateId.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.UpdateId.Name = "UpdateId";
            this.UpdateId.Size = new System.Drawing.Size(502, 20);
            this.UpdateId.TabIndex = 4;
            // 
            // UpdateLastname
            // 
            this.UpdateLastname.Location = new System.Drawing.Point(10, 274);
            this.UpdateLastname.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.UpdateLastname.Name = "UpdateLastname";
            this.UpdateLastname.Size = new System.Drawing.Size(501, 20);
            this.UpdateLastname.TabIndex = 5;
            // 
            // UpdatePhoneNumber
            // 
            this.UpdatePhoneNumber.Location = new System.Drawing.Point(10, 297);
            this.UpdatePhoneNumber.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.UpdatePhoneNumber.Name = "UpdatePhoneNumber";
            this.UpdatePhoneNumber.Size = new System.Drawing.Size(501, 20);
            this.UpdatePhoneNumber.TabIndex = 6;
            // 
            // UpdateButton
            // 
            this.UpdateButton.Location = new System.Drawing.Point(514, 250);
            this.UpdateButton.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.UpdateButton.Name = "UpdateButton";
            this.UpdateButton.Size = new System.Drawing.Size(83, 25);
            this.UpdateButton.TabIndex = 7;
            this.UpdateButton.Text = "UpdateButton";
            this.UpdateButton.UseVisualStyleBackColor = true;
            this.UpdateButton.Click += new System.EventHandler(this.UpdateButton_Click);
            // 
            // SaveButton
            // 
            this.SaveButton.Location = new System.Drawing.Point(515, 290);
            this.SaveButton.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.SaveButton.Name = "SaveButton";
            this.SaveButton.Size = new System.Drawing.Size(82, 25);
            this.SaveButton.TabIndex = 8;
            this.SaveButton.Text = "SaveButton";
            this.SaveButton.UseVisualStyleBackColor = true;
            this.SaveButton.Click += new System.EventHandler(this.SaveButton_Click);
            // 
            // ContactsList
            // 
            this.ContactsList.AllowUserToAddRows = false;
            this.ContactsList.AllowUserToDeleteRows = false;
            this.ContactsList.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.ContactsList.Location = new System.Drawing.Point(10, 11);
            this.ContactsList.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.ContactsList.Name = "ContactsList";
            this.ContactsList.ReadOnly = true;
            this.ContactsList.RowHeadersWidth = 51;
            this.ContactsList.RowTemplate.Height = 24;
            this.ContactsList.Size = new System.Drawing.Size(500, 235);
            this.ContactsList.TabIndex = 9;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(600, 366);
            this.Controls.Add(this.ContactsList);
            this.Controls.Add(this.SaveButton);
            this.Controls.Add(this.UpdateButton);
            this.Controls.Add(this.UpdatePhoneNumber);
            this.Controls.Add(this.UpdateLastname);
            this.Controls.Add(this.UpdateId);
            this.Controls.Add(this.DeleteId);
            this.Controls.Add(this.DeleteButton);
            this.Controls.Add(this.RefreshButton);
            this.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.ContactsList)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button RefreshButton;
        private System.Windows.Forms.Button DeleteButton;
        private System.Windows.Forms.TextBox DeleteId;
        private System.Windows.Forms.TextBox UpdateId;
        private System.Windows.Forms.TextBox UpdateLastname;
        private System.Windows.Forms.TextBox UpdatePhoneNumber;
        private System.Windows.Forms.Button UpdateButton;
        private System.Windows.Forms.Button SaveButton;
        private System.Windows.Forms.DataGridView ContactsList;
    }
}

