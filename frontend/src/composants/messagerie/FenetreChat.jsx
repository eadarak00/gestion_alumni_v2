import React, { useRef, useEffect } from 'react';
import { User } from 'lucide-react';

const FenetreChat = ({ conversation, messages, currentUserId, onBack }) => {
    const messagesEndRef = useRef(null);
    const otherParticipant = conversation?.participants.find(p => p.id !== currentUserId);

    useEffect(() => {
        messagesEndRef.current?.scrollIntoView({ behavior: 'smooth' });
    }, [messages]);

    if (!conversation) {
        return (
            <div className="h-full flex flex-col items-center justify-center text-gray-400 bg-gray-50/50">
                <div className="w-16 h-16 bg-gray-100 rounded-full flex items-center justify-center mb-4">
                    <User className="w-8 h-8 text-gray-300" />
                </div>
                <p>Sélectionnez une conversation pour commencer</p>
            </div>
        );
    }

    return (
        <>
            {/* Header Conversation */}
            <div className="h-16 flex items-center justify-between px-4 md:px-6 bg-white border-b border-gray-100 shadow-sm z-10">
                <div className="flex items-center gap-3">
                    <button
                        onClick={onBack}
                        className="md:hidden p-2 -ml-2 text-gray-600 hover:bg-gray-100 rounded-full"
                    >
                        <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M15 19l-7-7 7-7" /></svg>
                    </button>

                    <div className="relative">
                        {otherParticipant?.avatar ? (
                            <img
                                src={otherParticipant.avatar}
                                alt={otherParticipant.name}
                                className="w-10 h-10 rounded-full object-cover border border-gray-100 shadow-sm"
                            />
                        ) : (
                            <div className="w-10 h-10 rounded-full bg-emerald-100 flex items-center justify-center text-emerald-600 border border-emerald-200">
                                <User className="w-5 h-5" />
                            </div>
                        )}
                        <span className="absolute bottom-0 right-0 w-3 h-3 bg-green-500 border-2 border-white rounded-full"></span>
                    </div>

                    <div>
                        <h3 className="font-bold text-gray-900 text-sm md:text-base leading-tight">
                            {otherParticipant?.name}
                        </h3>
                        <span className="text-xs text-green-600 font-medium">En ligne</span>
                    </div>
                </div>
            </div>

            {/* Zone des Messages */}
            <div className="flex-1 overflow-y-auto p-4 md:p-6 space-y-6 bg-gray-50/30 scrollbar-thin scrollbar-thumb-gray-200">
                {/* Date separator example - could be improved with logic */}
                <div className="flex justify-center">
                    <span className="text-xs font-medium text-gray-400 bg-gray-100 px-3 py-1 rounded-full">
                        Aujourd'hui
                    </span>
                </div>

                {messages.map((msg, index) => {
                    const isMe = msg.senderId === currentUserId;
                    const participant = conversation.participants.find(p => p.id === msg.senderId);
                    const showHeader = index === 0 || messages[index - 1].senderId !== msg.senderId;

                    return (
                        <div
                            key={msg.id}
                            className={`flex flex-col w-full ${isMe ? 'items-end' : 'items-start'} mb-2`}
                        >
                            {showHeader && (
                                <div className={`flex items-center gap-2 mb-1 ${isMe ? 'flex-row-reverse' : 'flex-row'}`}>
                                    {(!isMe && participant?.avatar) && (
                                        <img
                                            src={participant.avatar}
                                            alt={participant.name}
                                            className="w-8 h-8 rounded-full object-cover border border-gray-100 hidden md:block"
                                        />
                                    )}
                                    <span className="text-xs font-bold text-gray-600">
                                        {participant?.name || 'Inconnu'}
                                    </span>
                                    <span className="text-[10px] text-gray-400">
                                        • {new Date(msg.timestamp).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}
                                    </span>
                                </div>
                            )}

                            <div
                                className={`
                                  max-w-[85%] md:max-w-[70%] px-4 py-2 rounded-2xl shadow-sm text-sm leading-relaxed relative group
                                  ${isMe
                                        ? 'bg-emerald-600 text-white rounded-tr-none'
                                        : 'bg-white text-gray-800 border border-gray-100 rounded-tl-none'}
                                  ${!showHeader ? (isMe ? 'mr-0' : 'ml-0 md:ml-10') : ''} 
                                `}
                            >
                                <p>{msg.text}</p>
                            </div>
                        </div>
                    );
                })}
                <div ref={messagesEndRef} />
            </div>
        </>
    );
};

import PropTypes from 'prop-types';

FenetreChat.propTypes = {
    conversation: PropTypes.object,
    messages: PropTypes.array,
    currentUserId: PropTypes.string.isRequired,
    onBack: PropTypes.func.isRequired,
};

export default FenetreChat;
