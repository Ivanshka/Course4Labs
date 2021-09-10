using System;
using System.Diagnostics;
using System.Net.WebSockets;
using System.Threading;
using System.Threading.Tasks;
using System.Web;
using System.Web.WebSockets;

namespace WebApplication1b
{
    public class WebSocketHandler : IHttpHandler
    {
        WebSocket socket;
        public bool IsReusable
        {
            get { return true; }
        }

        public void ProcessRequest(HttpContext context)
        {
            if (context.IsWebSocketRequest)
            {
                context.AcceptWebSocketRequest(WebSocketRequest);
            }
        }

        private async Task WebSocketRequest(AspNetWebSocketContext context)
        {
            int i = 0;
            socket = context.WebSocket;
            string s = await Receive();
            await Send(s);

            Thread myThread = new Thread(new ThreadStart(listenToStopCommand));
            myThread.Start();

            Debug.WriteLine("websocket has started");
            try
            {
                while (socket.State == WebSocketState.Open)
                {
                    System.Threading.Thread.Sleep(2000);
                    DateTime time = DateTime.Now;
                    await Send("[" + time + "]");
                    Debug.WriteLine(time + " was sent");
                }
            }
            catch (WebSocketException e)
            {
                Debug.WriteLine("websocket has been stopped inccorectly");
                _ = socket.CloseAsync(WebSocketCloseStatus.EndpointUnavailable,
                    "websocket has been closed incorrectly", CancellationToken.None);
            }
        }

        private async Task<string> Receive()
        {
            string rc = null;
            var buffer = new ArraySegment<byte>(new byte[512]);
            var result = await socket.ReceiveAsync(buffer, CancellationToken.None);
            rc = System.Text.Encoding.UTF8.GetString(buffer.Array, 0, result.Count);
            return rc;
        }

        private async Task Send(string s)
        {
            var sendbuffer = new ArraySegment<byte>(System.Text.Encoding.UTF8.GetBytes("Ответ: " + s));
            await socket.SendAsync(sendbuffer, System.Net.WebSockets.WebSocketMessageType.Text, true, CancellationToken.None);
        }

        private async void listenToStopCommand()
        {
            string rc = null;

            do
            {
                var buffer = new ArraySegment<byte>(new byte[512]);

                Debug.WriteLine("[LISTENER] listening to command ...");

                var result = await socket.ReceiveAsync(buffer, CancellationToken.None);
                rc = System.Text.Encoding.UTF8.GetString(buffer.Array, 0, result.Count);

                Debug.WriteLine("[LISTENER] " + rc + " command was received");

                if (rc.Equals("stop"))
                {
                    Debug.WriteLine("[LISTENER] websocket has been stopped");
                    _ = socket.CloseAsync(WebSocketCloseStatus.NormalClosure,
                        "websocket has been closed", CancellationToken.None);
                    return;
                }
                else
                {
                    Debug.WriteLine("[LISTENER] unknown command " + rc);
                }

            } while (rc == null || rc.Equals("stop"));
        }
    }
}
