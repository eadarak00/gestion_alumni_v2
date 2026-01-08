import React, { useState } from 'react';
import { Send, Paperclip } from 'lucide-react';

const EntreeMessage = ({ onSendMessage, disabled }) => {
    const [message, setMessage] = useState('');

    const handleSend = (e) => {
        e.preventDefault();
        if (message.trim() && !disabled) {
            onSendMessage(message);
            setMessage('');
        }
    };

    return (
        <div className="p-4 bg-white border-t border-gray-100">
            <form
                onSubmit={handleSend}
                className="flex items-end gap-2 max-w-4xl mx-auto"
            >
                <button
                    type="button"
                    disabled={disabled}
                    className="p-3 text-gray-400 hover:text-gray-600 hover:bg-gray-100 rounded-xl transition-colors"
                >
                    <Paperclip className="w-5 h-5" />
                </button>

                <div className="flex-1 bg-gray-50 border border-gray-200 rounded-2xl pl-4 pr-2 py-2 focus-within:ring-2 focus-within:ring-emerald-500/20 focus-within:border-emerald-500 transition-all shadow-inner">
                    <input
                        type="text"
                        className="w-full bg-transparent border-none focus:ring-0 text-sm text-gray-800 placeholder-gray-400 max-h-32 py-1.5"
                        placeholder="Écrivez votre message..."
                        value={message}
                        onChange={(e) => setMessage(e.target.value)}
                        disabled={disabled}
                    />
                </div>

                <button
                    type="submit"
                    disabled={!message.trim() || disabled}
                    className={`
            p-3 rounded-xl transition-all duration-200 flex items-center justify-center shadow-lg
            ${message.trim() && !disabled
                            ? 'bg-emerald-600 text-white hover:bg-emerald-700 shadow-emerald-200'
                            : 'bg-gray-200 text-gray-400 cursor-not-allowed'}
          `}
                >
                    <Send className="w-5 h-5" />
                </button>
            </form>
        </div>
    );
};

import PropTypes from 'prop-types';

EntreeMessage.propTypes = {
    onSendMessage: PropTypes.func.isRequired,
    disabled: PropTypes.bool,
};

export default EntreeMessage;
